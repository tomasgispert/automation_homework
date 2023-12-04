package com.solvd.enums;

public enum MuscleGroup {
    ARM("Arm"),
    LEG("Leg"),
    CORE("Core"),
    TRUNK("Trunk"),
    BACK("Back"),
    SHOULDER("Shoulder"),
    CHEST("Chest"),
    MISCELLANEOUS("Miscellaneous");

    private final String groupName;

    MuscleGroup(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }
}
