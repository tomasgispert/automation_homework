package week2;

import java.util.ArrayList;
import java.util.Objects;

public class Workout {
    private int workoutId;
    private String name;
    ArrayList<Exercise> exercises;
    private int difficulty;
    Instructor instructor;
    private String additionalInfo;

    public Workout(int workoutId, String name, ArrayList<Exercise> exercises, int difficulty, Instructor instructor, String additionalInfo) {
        this.workoutId = workoutId;
        this.name = name;
        this.exercises = exercises;
        this.difficulty = difficulty;
        this.instructor = instructor;
        this.additionalInfo = additionalInfo;
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "workoutId=" + workoutId +
                ", name='" + name + '\'' +
                ", exercises=" + exercises +
                ", difficulty=" + difficulty +
                ", instructor=" + instructor +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Workout)) return false;
        Workout workout = (Workout) o;
        return workoutId == workout.workoutId && difficulty == workout.difficulty && Objects.equals(name, workout.name) && Objects.equals(exercises, workout.exercises) && Objects.equals(instructor, workout.instructor) && Objects.equals(additionalInfo, workout.additionalInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutId, name, exercises, difficulty, instructor, additionalInfo);
    }
}
