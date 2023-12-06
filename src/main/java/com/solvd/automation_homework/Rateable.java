package com.solvd.automation_homework;

@FunctionalInterface
public interface Rateable<T> {
    double rate(T item);
}
