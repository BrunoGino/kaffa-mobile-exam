package cnpj;

import cnpj.utils.CNPJUtils;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.List;

public class CNPJValidator {
    private CNPJUtils cnpjUtils;

    public CNPJValidator() {
        this.cnpjUtils = new CNPJUtils();
    }

    public boolean isStringLikeCNPJ(String cnpjValue) {
        try {
            return isNotBlankStringLikeCNPJ(cnpjValue);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isNotBlankStringLikeCNPJ(String cnpjValue) {
        if (cnpjValue == null || cnpjValue.isEmpty()) {
            return false;
        } else {
            return isCNPJConvertibleToLong(cnpjValue.trim());
        }
    }

    private boolean isCNPJConvertibleToLong(String cnpjValue) {
        if (cnpjValue.length() == 14) {
            cnpjToLong(cnpjValue);
            return true;
        } else if (cnpjValue.length() == 18 && hasMask(cnpjValue)) {
            String collect = getCnpjUnformatted(cnpjValue);
            cnpjToLong(collect);
            return true;
        } else {
            return false;
        }
    }

    public String getCnpjUnformatted(String cnpjValue) {
        List<String> characters = cnpjUtils.parseArrayOfCharsAsListOfString(cnpjValue);
        characters.removeIf(character -> character.equals(".") || character.equals("/") || character.equals("-"));
        return String.join("", characters);
    }

    private Long cnpjToLong(String value) {
        return Long.parseLong(value);
    }

    public boolean hasMask(String cnpjValue) {
        try {
            MaskFormatter maskFormatter = new MaskFormatter("##.###.###/####-##");
            String formattedCnpj = maskFormatter.valueToString(cnpjValue);
            return cnpjValue.equals(formattedCnpj);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
