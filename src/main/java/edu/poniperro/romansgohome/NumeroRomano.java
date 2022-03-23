package edu.poniperro.romansgohome;


import java.util.HashMap;

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
        if(this.numeroRomano.matches("M")) {
            return regexs.get("M");
        }
        return 0;
    }
    
}
