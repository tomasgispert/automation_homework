package com.solvd.automation_homework;

import com.solvd.enums.PaymentMethod;

public interface Payable {
    double getCost(PaymentMethod method);
}
