package edu.poniperro.romansgohome;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumberRegexsTest {

    static RomanNumberRegexs regexs;

    @BeforeAll
    public static void initializeRegexs() {
        regexs = new RomanNumberRegexs();
    }

    @Test
    public void getRegexsByKey() {
        String key = "grupo sumatorio";
        String actual = regexs.getRegexsByKey(key);
        assertEquals("[MDCLXVI]", actual);
    }

    @Test
    public void getAllRegexs() {
        HashMap<String, String> actualRegexs = regexs.getAllRegexs();
        assertEquals("{grupo sumatorio=[MDCLXVI]}", actualRegexs.toString());
    }
}