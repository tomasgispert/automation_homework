package com.solvd.automation_homework;

import com.solvd.enums.PaymentMethod;

public class Membership implements Payable {
    private String type;
    private double fee;
    private int feeDuration;
    private boolean isAutoRenewal;
    private String conditions;

    public Membership(String type, double fee, int feeDuration, boolean isAutoRenewal, String conditions) {
        this.type = type;
        this.fee = fee;
        this.feeDuration = feeDuration;
        this.isAutoRenewal = isAutoRenewal;
        this.conditions = conditions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getFeeDuration() {
        return feeDuration;
    }

    public void setFeeDuration(int feeDuration) {
        this.feeDuration = feeDuration;
    }

    public boolean isAutoRenewal() {
        return isAutoRenewal;
    }

    public void setAutoRenewal(boolean autoRenewal) {
        isAutoRenewal = autoRenewal;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "type='" + type + '\'' +
                ", fee=" + fee +
                ", feeDuration=" + feeDuration +
                ", isAutoRenewal=" + isAutoRenewal +
                ", conditions='" + conditions + '\'' +
                '}';
    }

    @Override
    public double getCost(PaymentMethod method) {
        return this.getFee()*method.getModifier();
    }
}
