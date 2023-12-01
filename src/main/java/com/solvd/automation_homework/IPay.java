package main.java.com.solvd.automation_homework;

public interface IPay {
    Payment makePayment(double amount,String paymentMethod) throws InsufficientMoneyException;
}
