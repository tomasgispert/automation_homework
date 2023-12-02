package com.solvd.automation_homework;

import java.util.List;
import java.util.Objects;

public class Exercise{
    private String name;
    private String description;
    private List<Muscle> musclesWorked;
    private List<Equipment> equipmentRequired;

    public Exercise(String name, String description, List<Muscle> musclesWorked, List<Equipment> equipmentRequired) {
        this.name = name;
        this.description = description;
        this.musclesWorked = musclesWorked;
        this.equipmentRequired = equipmentRequired;
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

    public List<Muscle> getMusclesWorked() {
        return musclesWorked;
    }

    public void setMusclesWorked(List<Muscle> musclesWorked) {
        this.musclesWorked = musclesWorked;
    }

    public List<Equipment> getEquipmentRequired() {
        return equipmentRequired;
    }

    public void setEquipmentRequired(List<Equipment> equipmentRequired) {
        this.equipmentRequired = equipmentRequired;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", musclesWorked=" + musclesWorked +
                ", equipmentRequired=" + equipmentRequired +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exercise)) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(name, exercise.name) && Objects.equals(description, exercise.description) && Objects.equals(musclesWorked, exercise.musclesWorked) && Objects.equals(equipmentRequired, exercise.equipmentRequired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, musclesWorked, equipmentRequired);
    }
}
