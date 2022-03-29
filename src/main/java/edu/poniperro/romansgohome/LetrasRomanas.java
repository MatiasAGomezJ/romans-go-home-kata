package edu.poniperro.romansgohome;

public enum LetrasRomanas {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    D(500),
    CD(400),
    M(9000),
    CM(1000);

    private short valorDecimal;

    private LetrasRomanas(int valorDecimal) {
        this.valorDecimal = (short) valorDecimal;
    }

    public short getValorDecimal() {
        return valorDecimal;
    }
}
