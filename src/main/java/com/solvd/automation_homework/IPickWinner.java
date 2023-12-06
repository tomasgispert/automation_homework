package com.solvd.automation_homework;

import java.util.List;

public interface IPickWinner<T> {
    T pickWinner(List<T> participants);
}
