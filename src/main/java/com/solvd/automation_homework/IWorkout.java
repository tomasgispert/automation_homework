package com.solvd.automation_homework;

public interface IWorkout{
    Session completeSession(Workout workout,double rpe) throws InvalidIntensityException;
}
