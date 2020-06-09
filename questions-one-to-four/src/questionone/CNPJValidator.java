package questionone;

import questionone.utils.CNPJUtils;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class CNPJValidator {
    private CNPJUtils cnpjUtils;

    public CNPJValidator() {
        this.cnpjUtils = new CNPJUtils();
    }

    public boolean isCnpjValid(CNPJ cnpj) {
        if (cnpj.isStringLikeCNPJ() && cnpjIsNotZero(cnpj)) {
            String cnpjValue = cnpj.getCnpjUnformatted(cnpj.getValue());
            StringBuilder cnpjWithNoIDDigits = new StringBuilder();
            cnpjWithNoIDDigits.append(cnpjValue, 0, 12);
            String endDigits = getEndDigits(cnpjWithNoIDDigits);
            return cnpjValue.endsWith(endDigits);
        } else {
            return false;
        }
    }

    private boolean cnpjIsNotZero(CNPJ cnpj) {
        return !cnpj.getCnpjUnformatted(cnpj.getValue()).equals("00000000000000");
    }

    private String getEndDigits(StringBuilder cnpjWithNoIDDigits) {
        StringBuilder endDigits = new StringBuilder();
        int firstIDDigit = getFirstIDDigit(cnpjWithNoIDDigits.toString());

        endDigits.append(firstIDDigit);
        cnpjWithNoIDDigits.append(endDigits);

        int secondIDDigit = getSecondIDDigit(cnpjWithNoIDDigits.toString());
        endDigits.append(secondIDDigit);
        return endDigits.toString();
    }

    private int getSecondIDDigit(String cnpjWithFirstIDDigit) {

        int secondSum = getSumForSecondMultiplicands(cnpjWithFirstIDDigit);

        return getModulo(secondSum);
    }

    private int getFirstIDDigit(String cnpjWithNoIdDigits) {
        int sum = getSumForFirstMultiplicands(cnpjWithNoIdDigits);
        return getModulo(sum);
    }

    private int getModulo(int sum) {
        int rest = (sum % 11);

        if (rest < 2) {
            rest = 0;
        } else {
            rest = 11 - rest;
        }
        return rest;
    }

    private int getSumForSecondMultiplicands(String cnpjWithFoundDigit) {
        List<Integer> secondMultiplicands = Arrays.asList(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2);
        List<String> cnpjNumbersList = cnpjUtils.parseArrayOfCharsAsListOfString(cnpjWithFoundDigit);

        return cnpjNumbersList.stream().mapToInt(value ->
                Integer.parseInt(value) * secondMultiplicands.get(cnpjNumbersList.indexOf(value))).sum();
    }

    private int getSumForFirstMultiplicands(String cnpjWithNoIDDigits) {
        List<Integer> firstMultiplicands = Arrays.asList(5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2);
        List<String> cnpjNumbersList = cnpjUtils.parseArrayOfCharsAsListOfString(cnpjWithNoIDDigits);

        return cnpjNumbersList.stream().mapToInt(value ->
                Integer.parseInt(value) * firstMultiplicands.get(cnpjNumbersList.indexOf(value))).sum();
    }

    public String applyMask(CNPJ cnpj) {
        try {
            MaskFormatter maskFormatter = new MaskFormatter("##.###.###/####-##");
            maskFormatter.setValueContainsLiteralCharacters(true);
            return maskFormatter.valueToString(cnpj.getValue());
        } catch (ParseException e) {
            e.printStackTrace();
            return "Could not parse CNPJ, please check its text";
        }
    }
}
