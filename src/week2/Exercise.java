package week2;

import java.util.ArrayList;

public class Exercise {
    private int exerciseId;
    private String name;
    private String description;
    private int suggestedMinReps;
    private int getSuggestedMaxReps;
    ArrayList<Muscle> musclesWorked;
    ArrayList<Equipment> equipmentRequired;

    public Exercise(int exerciseId, String name, String description, int suggestedMinReps, int getSuggestedMaxReps,ArrayList<Muscle> musclesWorked, ArrayList<Equipment> equipmentRequired) {
        this.exerciseId = exerciseId;
        this.name = name;
        this.description = description;
        this.suggestedMinReps = suggestedMinReps;
        this.getSuggestedMaxReps = getSuggestedMaxReps;
        this.musclesWorked = musclesWorked;
        this.equipmentRequired = equipmentRequired;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSuggestedMinReps() {
        return suggestedMinReps;
    }

    public void setSuggestedMinReps(int suggestedMinReps) {
        this.suggestedMinReps = suggestedMinReps;
    }

    public int getGetSuggestedMaxReps() {
        return getSuggestedMaxReps;
    }

    public void setGetSuggestedMaxReps(int getSuggestedMaxReps) {
        this.getSuggestedMaxReps = getSuggestedMaxReps;
    }

    public ArrayList<Muscle> getMusclesWorked() {
        return musclesWorked;
    }

    public void setMusclesWorked(ArrayList<Muscle> musclesWorked) {
        this.musclesWorked = musclesWorked;
    }

    public ArrayList<Equipment> getEquipmentRequired() {
        return equipmentRequired;
    }

    public void setEquipmentRequired(ArrayList<Equipment> equipmentRequired) {
        this.equipmentRequired = equipmentRequired;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "exerciseId=" + exerciseId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", suggestedMinReps=" + suggestedMinReps +
                ", getSuggestedMaxReps=" + getSuggestedMaxReps +
                ", musclesWorked=" + musclesWorked +
                ", equipmentRequired=" + equipmentRequired +
                '}';
    }
}
