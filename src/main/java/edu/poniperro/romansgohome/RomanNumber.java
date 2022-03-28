package edu.poniperro.romansgohome;


import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {
    private String numeroRomano;
    private HashMap<String, Short> regexs;
    private short numeroDecimal = 0;

    public RomanNumber(String numeroRomano) {
        initRegexDicionario();
        this.numeroRomano = numeroRomano;
    }

    public void initRegexDicionario() {
        regexs = new HashMap<>();
        regexs.put("M", (short) 1000);
        regexs.put("D", (short) 500);
        regexs.put("C", (short) 100);
        regexs.put("X", (short) 10);
        regexs.put("I", (short) 1);
    }

    public String getNumeroRomano() {
        return this.numeroRomano;
    }

    private short getNumeroDecimal() {
        return numeroDecimal;
    }

    private void setNumeroDecimal(short numeroDecimal) {
        this.numeroDecimal = numeroDecimal;
    }

    public short toDecimal() {
        for (String key : regexs.keySet()) {
            Matcher matcher = getMatcher(key);

            while (matcher.find()) {
                short decimal = getDecimalFrom(matcher.group());
                sumarDecimal(decimal);
            }
        }
        return getNumeroDecimal();
    }

    private void sumarDecimal(short decimal) {
        setNumeroDecimal((short) (getNumeroDecimal() + decimal));
    }

    private short getDecimalFrom(String group) {
        return LetrasRomanas.valueOf(group).getValorDecimal();
    }


    private Matcher getMatcher(String key) {
        Pattern pattern = Pattern.compile(key);
        Matcher matcher = pattern.matcher(getNumeroRomano());
        return matcher;
    }

}
