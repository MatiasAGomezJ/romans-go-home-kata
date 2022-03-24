package edu.poniperro.romansgohome;


import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumeroRomano {
    private String numeroRomano;
    private HashMap<String, Integer> regexs;

    public void initRegexDicionario() {
        regexs = new HashMap<>();
        regexs.put("M", 1000);
        regexs.put("D", 500);
        regexs.put("C", 100);
        regexs.put("X", 10);
        regexs.put("I", 1);
    }

    public void setNumeroRomano(String numeroRomano) {
        this.numeroRomano = numeroRomano;
    }

    public int toDecimal() {
        int numeroDecimal = 0;

        for (String key :
                regexs.keySet()) {

            Pattern p = Pattern.compile(key);
            Matcher m = p.matcher(getNumeroRomano());

            while (m.find()) {
                numeroDecimal += regexs.get(key);
            }
        }
        return numeroDecimal;
    }

    public String getNumeroRomano() {
        return this.numeroRomano;
    }
}
