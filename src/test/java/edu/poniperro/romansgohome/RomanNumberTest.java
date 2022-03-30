package edu.poniperro.romansgohome;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RomanNumberTest {

    public RomanNumber numeroRomano;

    @ParameterizedTest
    @CsvSource({
            "1000,  M",
            "2000,  UMMU",
            "3000,  UMMMU",
            "3300,  UMMMUCCCU",
            "3030,  UMMMUXXXU",
            "3003,  UMMMUIIIU",
            "3503,  UMMMUDUIIIU"
    })
    public void grupoSumatorioTest(short decimal, String roman) {
        numeroRomano = new RomanNumber(roman);
        assertEquals(decimal, numeroRomano.toDecimal());
    }

    @ParameterizedTest
    @CsvSource({
            "400,   UCDU",
            "900,   UCMU",
            "40,    UXLU",
            "90,    UXCU",
            "4,     UIVU",
            "9,     UIXU",
            "3888,  MMMDCCCLXXXVIII",
            "2777,  MMDCCLXXVII",
            "444,   CDXLIV",
            "439,   CDXXXIX",
            "3403, MMMUCDUIIIU"
    })
    public void grupoSustractivoTest(short decimal, String roman) {
        numeroRomano = new RomanNumber(roman);
        assertEquals(decimal, numeroRomano.toDecimal());
    }

    @Test
    public void init_regex_collection_test() {
        String testCase = "V";
        numeroRomano = new RomanNumber(testCase);
        assertThat(numeroRomano.getRegexCollection().getAllRegex()).hasSize(2);

        assertThat(numeroRomano.getRegexCollection().getAllRegex()).containsExactly("(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX])", "(C[DM])|(X[LC])|(I[VX])");

        assertThat(numeroRomano.getRegexCollection().getRegex("grupoSumatorio")).isEqualTo("(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX])");
        assertThat(numeroRomano.getRegexCollection().getRegex("grupoSustractivo")).isEqualTo("(C[DM])|(X[LC])|(I[VX])");
    }

    @ParameterizedTest
    @CsvSource({
            "5,   V",
            "4,   IV",
            "900, CM"
    })
    public void valor_decimal_test(short decimal, String roman) {
        numeroRomano = new RomanNumber(roman);
        assertEquals(decimal, numeroRomano.decimalValue(roman));
    }
}