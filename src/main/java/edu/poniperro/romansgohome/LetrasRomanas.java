package edu.poniperro.romansgohome;

public enum LetrasRomanas {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private short valorDecimal;

    private LetrasRomanas(int valorDecimal) {
        this.valorDecimal = (short) valorDecimal;
    }

    public short getValorDecimal() {
        return valorDecimal;
    }
}
