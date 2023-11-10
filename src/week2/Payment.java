package week2;

import java.util.Date;

public class Payment {
    private Date date;
    private double amount;
    private Person payer;
    private String paymentMethod;

    public Payment(Date date, double amount, Person payer, String paymentMethod) {
        this.date = date;
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

    @Override
    public String toString() {
        return "Payment{" +
                ", date=" + date +
                ", amount=" + amount +
                ", member=" + payer +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
