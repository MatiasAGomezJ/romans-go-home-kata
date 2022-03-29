package edu.poniperro.romansgohome;


import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {
    private String numeroRomano;
    private short numeroDecimal = 0;
    private RomanNumberRegexs regexs = null;

    public RomanNumber(String numeroRomano) {
        this.numeroRomano = numeroRomano;
        regexs = new RomanNumberRegexs();
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
        for (String key : getRegexsValues()) {
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

    private Collection<String> getRegexsValues() {
        return regexs.getAllRegexs().values();
    }

    @Override
    public String toString() {
        return numeroRomano;
    }
}
