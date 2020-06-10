package cnpj;

public class CNPJTest {
    public static void main(String[] args) {
        CNPJ unformattedCNPJ = new CNPJ("00000000000000");
        CNPJ formattedCNPJ = new CNPJ("12.324.567/8912-34");

        CNPJValidator cnpjValidator = new CNPJValidator();

        System.out.println("Is like a CNPJ ? " + cnpjValidator.isStringLikeCNPJ(unformattedCNPJ.getValue()));
        System.out.println("Is like a CNPJ ? " + cnpjValidator.isStringLikeCNPJ(formattedCNPJ.getValue()));

        // Will not set value, as input doesn't look like a CNPJ
        unformattedCNPJ.setValue("qwertyuiopasdf", cnpjValidator);
        System.out.println(unformattedCNPJ.getValue());
    }
}
