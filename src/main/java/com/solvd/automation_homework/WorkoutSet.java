package com.solvd.automation_homework;

import java.util.List;

public class WorkoutSet extends Exercise implements IVolume{
    private int reps;
    private double weight;
    private double rpe;

    public WorkoutSet(String name, String description, List<Muscle> musclesWorked, List<Equipment> equipmentRequired, int reps, double weight, double rpe) {
        super(name, description, musclesWorked, equipmentRequired);
        this.reps = reps;
        this.weight = weight;
        this.rpe = rpe;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getRpe() {
        return rpe;
    }

    public void setRpe(int rpe) {
        this.rpe = rpe;
    }

    @Override
    public double getVolume() {
        return this.getWeight() * this.getReps();
    }
}
