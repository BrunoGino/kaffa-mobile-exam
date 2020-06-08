package questionone;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CNPJTest {

    @Test
    public void must_CheckIfCNPJIsValid_WhenStringIsFormatted() {
        CNPJ cnpj = new CNPJ("00.000.000/0000-00");
        CNPJValidator cnpjValidator = new CNPJValidator();

        assertTrue(cnpjValidator.isCnpjValid(cnpj));
    }

    @Test
    public void must_CheckIfCNPJIsValid_WhenStringIsNotFormatted(){
        CNPJ cnpj = new CNPJ("00000000000000");
        CNPJValidator cnpjValidator = new CNPJValidator();

        assertTrue(cnpjValidator.isCnpjValid(cnpj));
    }

}
