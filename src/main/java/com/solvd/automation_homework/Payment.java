package com.solvd.automation_homework;

import java.util.Date;

public class Payment {
    private Date date;
    private double amount;
    private Person payer;
    private String paymentMethod;
    private String month;

    public Payment(Date date, String month, double amount, Person payer, String paymentMethod) {
        this.date = date;
        this.month = month;
        this.amount = amount;
        this.payer = payer;
        this.paymentMethod = paymentMethod;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Person getPayer() {
        return payer;
    }

    public void setPayer(Person payer) {
        this.payer = payer;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "date=" + date +
                ", amount=" + amount +
                ", payer=" + payer +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
