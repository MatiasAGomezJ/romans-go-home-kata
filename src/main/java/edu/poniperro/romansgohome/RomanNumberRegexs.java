package edu.poniperro.romansgohome;

import java.util.HashMap;

public class RomanNumberRegexs {

    private HashMap<String, String> regexs = new HashMap<>();

    public RomanNumberRegexs() {
        initRegexDicionario();
    }

    private void initRegexDicionario() {
        addRegex("grupo sumatorio", "[MDCLXVI]");
    }

    public void addRegex(String description, String regularExppresion) {
        regexs.putIfAbsent(description, regularExppresion);
    }

    public String getRegexsByKey(String description) {
        return regexs.get(description);
    }

    public HashMap<String, String> getAllRegexs() {
        return regexs;
    }

    @Override
    public String toString() {
        return regexs.toString();
    }
}
