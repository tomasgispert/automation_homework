package com.solvd.enums;

import com.solvd.automation_homework.Payable;

public enum MembershipType implements Payable {
    STANDARD("Standard",100),
    PREMIUM("Premium",150),
    VIP("VIP",200);

    private final String type;
    private final double basePrice;

    MembershipType(String type, double basePrice) {
        this.type = type;
        this.basePrice = basePrice;
    }

    public String getType() {
        return type;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public double getCost(PaymentMethod method) {
        return this.basePrice* method.getModifier();
    }
}
