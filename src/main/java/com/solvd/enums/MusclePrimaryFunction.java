package com.solvd.enums;

public enum MusclePrimaryFunction {
    FLEXOR("Flexor",MuscleGroup.ARM,"Flexes a joint"),
    EXTENSOR("Extensor",MuscleGroup.LEG,"Straightens or extends a joint"),
    ABDUCTOR("Abductor",MuscleGroup.LEG,"Moves a limb away from the midline"),
    ADDUCTOR("Adductor",MuscleGroup.LEG,"Moves a limb towards the midline"),
    ROTATOR("Rotator",MuscleGroup.CORE,"Rotates or twists the body"),
    STABILIZER("Stabilizer",MuscleGroup.TRUNK,"Provides support or stabilization");

    private final String functionName;
    private final MuscleGroup associatedMuscleGroup;
    private final String functionDescription;

    MusclePrimaryFunction(String functionName, MuscleGroup associatedMuscleGroup, String functionDescription) {
        this.functionName = functionName;
        this.associatedMuscleGroup = associatedMuscleGroup;
        this.functionDescription = functionDescription;
    }

    public String getFunctionName() {
        return functionName;
    }

    public MuscleGroup getAssociatedMuscleGroup() {
        return associatedMuscleGroup;
    }

    public String getFunctionDescription() {
        return functionDescription;
    }
}
