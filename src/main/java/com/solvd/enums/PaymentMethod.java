package com.solvd.enums;

public enum PaymentMethod {
    CASH("Cash",0.8),
    PAYPAL("Paypal",1),
    VISA("Visa",1.1),
    VISAD("Visa Debit",1),
    MASTERCARD("Mastercard",1.1),
    AMEX("Amex",1.15),
    STAFF("Staff member",0);

    private final String method;
    private final double modifier;

    PaymentMethod(String method, double modifier){
        this.method = method;
        this.modifier = modifier;
    }

    public String getMethod() {
        return method;
    }

    public double getModifier() {
        return modifier;
    }
}
