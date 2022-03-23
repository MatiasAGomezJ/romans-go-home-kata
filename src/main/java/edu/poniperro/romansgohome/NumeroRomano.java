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
    }

    public void setNumeroRomano(String numeroRomano) {
        this.numeroRomano = numeroRomano;
    }

    public int toDecimal() {
        Pattern p = Pattern.compile("M");
        Matcher m = p.matcher(getNumeroRomano());

        int numeroDecimal = 0;

        while(m.find()) {
            numeroDecimal += regexs.get("M");
        }
        return numeroDecimal;
    }

    public String getNumeroRomano() {
        return this.numeroRomano;
    }
}
