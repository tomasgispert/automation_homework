package com.solvd.automation_homework;

public interface IWorkout{
    Session completeSession(Workout workout,int rpe) throws InvalidIntensityException;
}
