package com.solvd.automation_homework;

import com.solvd.enums.PaymentMethod;

@FunctionalInterface
public interface Payable {
    double getCost(PaymentMethod method);
}
