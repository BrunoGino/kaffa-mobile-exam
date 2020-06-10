package cnpj;

public class CNPJ {
    private String value;

    public CNPJ(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value, CNPJValidator cnpjValidator) {
        if (cnpjValidator.isStringLikeCNPJ(value)) {
            this.value = value.trim();
        }
    }
}
