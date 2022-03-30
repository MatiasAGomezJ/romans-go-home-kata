package edu.poniperro.romansgohome;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumberRegexsTest {

    static RomanNumberRegexs regexs;

    @BeforeAll
    public static void initializeRegexs() {
        regexs = new RomanNumberRegexs();
    }

    @Test
    public void getRegexsByKey() {
        String key = "grupoSumatorio";
        String actual = regexs.getRegex(key);
        assertEquals("(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX])", actual);
    }

    @Test
    public void getAllRegex() {
        Collection<String> actualRegexs = regexs.getAllRegex();
        assertEquals("[(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX]), (C[DM])|(X[LC])|(I[VX])]", actualRegexs.toString());
    }
}