package com.solvd.automation_homework;

@FunctionalInterface
public interface IWorkout{
    Session completeSession(Workout workout,double rpe) throws InvalidIntensityException;
}
