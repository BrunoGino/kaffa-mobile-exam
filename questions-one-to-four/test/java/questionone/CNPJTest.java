package questionone;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CNPJTest {

    @Test
    public void must_CheckIfFormattedCnpj_IsValid() {
        CNPJ cnpj = new CNPJ("32.290.342/0001-80");
        CNPJValidator cnpjValidator = new CNPJValidator();
        assertThat(cnpjValidator.isCnpjValid(cnpj), equalTo(true));
    }

    @Test
    public void must_CheckIfCNPJ_IsValid() {
        CNPJ cnpj = new CNPJ("32290342000180");
        CNPJValidator cnpjValidator = new CNPJValidator();
        assertThat(cnpjValidator.isCnpjValid(cnpj), equalTo(true));
    }

    @Test
    public void must_CheckIfFormattedInvalidCnpj_IsInvalid() {
        CNPJ cnpj = new CNPJ("12.345.678/9101-12");
        CNPJValidator cnpjValidator = new CNPJValidator();
        assertThat(cnpjValidator.isCnpjValid(cnpj), equalTo(false));
    }

    @Test
    public void must_CheckIfInvalidCNPJ_isInvalid() {
        CNPJ cnpj = new CNPJ("12345679910112");
        CNPJValidator cnpjValidator = new CNPJValidator();
        assertThat(cnpjValidator.isCnpjValid(cnpj), equalTo(false));
    }

    @Test
    public void must_CheckIfStringLooksLikeCNPJ_WhenStringIsFormatted() {
        CNPJ cnpj = new CNPJ("00.000.000/0000-00");

        assertThat(cnpj.getValue().length(), equalTo(18));
        assertThat(cnpj.isStringLikeCNPJ(), equalTo(true));
    }

    @Test
    public void must_CheckIfStringLooksLikeCNPJ_WhenStringIsNotFormatted() {
        CNPJ cnpj = new CNPJ("00000000000000");
        assertTrue(cnpj.isStringLikeCNPJ());
    }

    @Test
    public void must_CheckIfStringNotLooksLikeCnpj_WhenLetterIsInString() {
        CNPJ cnpj = new CNPJ("0000a000000000");
        assertThat(cnpj.isStringLikeCNPJ(), equalTo(false));
    }

    @Test
    public void must_CheckIfStringNotLooksLikeCnpj_WhenStringIsGreaterThanExpected() {
        CNPJ cnpj = new CNPJ("0000000000000000");
        assertThat(cnpj.isStringLikeCNPJ(), equalTo(false));
    }

    @Test
    public void must_CheckIfStringNotLooksLikeCnpj_WhenStringIsLessThanExpected() {
        CNPJ cnpj = new CNPJ("00000000000");
        assertThat(cnpj.isStringLikeCNPJ(), equalTo(false));
    }

    @Test
    public void must_CheckIfStringNotLooksLikeCNPJ_WhenStringIsEmptyOrNull() {
        CNPJ cnpj = new CNPJ("");
        CNPJ cnpj2 = new CNPJ(null);

        assertThat(cnpj.isStringLikeCNPJ(), equalTo(false));
        assertThat(cnpj2.isStringLikeCNPJ(), equalTo(false));
    }

}
