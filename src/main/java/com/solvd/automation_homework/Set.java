package main.java.com.solvd.automation_homework;

import java.util.ArrayList;

public class Set extends Exercise implements IVolume{
    private int reps;
    private double weight;
    private int rpe;

    public Set(String name, String description, ArrayList<Muscle> musclesWorked, ArrayList<Equipment> equipmentRequired, int reps, double weight, int rpe) {
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

    public int getRpe() {
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
