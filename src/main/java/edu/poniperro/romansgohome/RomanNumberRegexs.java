package edu.poniperro.romansgohome;

import java.util.Collection;
import java.util.HashMap;

public class RomanNumberRegexs {

    private HashMap<String, String> regexs = new HashMap<>();

    public RomanNumberRegexs() {
        initRegexDicionario();
    }

    private void initRegexDicionario() {
        addRegex("grupoSumatorio", "(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX])");
        addRegex("grupoSustractivo", "(C[DM])|(X[LC])|(I[VX])");
    }

    public void addRegex(String description, String regularExppresion) {
        regexs.putIfAbsent(description, regularExppresion);
    }

    public String getRegex(String description) {
        return regexs.get(description);
    }

    public Collection<String> getAllRegex() {
        return regexs.values();
    }

    @Override
    public String toString() {
        return regexs.toString();
    }
}
