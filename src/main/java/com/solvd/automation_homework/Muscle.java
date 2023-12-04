package com.solvd.automation_homework;

import com.solvd.enums.MusclePrimaryFunction;

public final class Muscle {
    private int muscleId;
    private final String name;
    private MusclePrimaryFunction primaryFunction;
    private boolean isMajorMuscle;

    public Muscle(int muscleId, String name, MusclePrimaryFunction primaryFunction, boolean isMajorMuscle) {
        this.muscleId = muscleId;
        this.name = name;
        this.primaryFunction = primaryFunction;
        this.isMajorMuscle = isMajorMuscle;
    }

    public int getMuscleId() {
        return muscleId;
    }

    public void setMuscleId(int muscleId) {
        this.muscleId = muscleId;
    }

    public String getName() {
        return name;
    }

    public MusclePrimaryFunction getPrimaryFunction() {
        return primaryFunction;
    }

    public void setPrimaryFunction(MusclePrimaryFunction primaryFunction) {
        this.primaryFunction = primaryFunction;
    }

    public boolean isMajorMuscle() {
        return isMajorMuscle;
    }

    public void setMajorMuscle(boolean majorMuscle) {
        isMajorMuscle = majorMuscle;
    }

    @Override
    public String toString() {
        return "Muscle{" +
                "muscleId=" + muscleId +
                ", name='" + name + '\'' +
                ", primaryFunction='" + primaryFunction.getFunctionDescription() + '\'' +
                ", isMajorMuscle=" + isMajorMuscle +
                '}';
    }
}
