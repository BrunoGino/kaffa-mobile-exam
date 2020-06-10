package cnpj;

import cnpj.utils.CNPJUtils;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.List;

public class CNPJ {
    private String value;
    private CNPJUtils cnpjUtils;

    public CNPJ(String value) {
        this.value = value;
        this.cnpjUtils = new CNPJUtils();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (isStringLikeCNPJ()) {
            this.value = value.trim();
        }
    }

    public boolean isStringLikeCNPJ() {
        try {
            return isNotBlankStringLikeCNPJ();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isNotBlankStringLikeCNPJ() {
        if (value == null || value.isEmpty()) {
            return false;
        } else {
            return isCNPJConvertibleToLong(value.trim());
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
