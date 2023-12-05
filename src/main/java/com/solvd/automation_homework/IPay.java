package com.solvd.automation_homework;

import com.solvd.enums.PaymentMethod;

@FunctionalInterface
public interface IPay {
    Payment makePayment(double amount, String month, PaymentMethod method) throws InsufficientMoneyException;
}
