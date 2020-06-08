package questionone;

public class CNPJ {
    private String value;

    public CNPJ(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean hasMask() {
        return false;
    }

}
