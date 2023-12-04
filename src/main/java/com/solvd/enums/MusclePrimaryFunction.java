package com.solvd.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public enum MusclePrimaryFunction {
    FLEXOR("Flexor", "Flexes a joint", MuscleGroup.ARM, MuscleGroup.LEG, MuscleGroup.CORE),
    EXTENSOR("Extensor", "Straightens or extends a joint", MuscleGroup.LEG, MuscleGroup.CORE, MuscleGroup.BACK),
    ABDUCTOR("Abductor", "Moves a limb away from the midline", MuscleGroup.LEG, MuscleGroup.CORE),
    ADDUCTOR("Adductor", "Moves a limb towards the midline", MuscleGroup.LEG, MuscleGroup.CORE),
    ROTATOR("Rotator", "Rotates or twists the body", MuscleGroup.CORE, MuscleGroup.BACK),
    STABILIZER("Stabilizer", "Provides support or stabilization", MuscleGroup.CORE, MuscleGroup.BACK);

    private final String functionName;
    private final String functionDescription;
    private final Set<MuscleGroup> associatedMuscleGroups;

    MusclePrimaryFunction(String functionName,String functionDescription,MuscleGroup... muscleGroups) {
        this.functionName = functionName;
        this.functionDescription = functionDescription;
        this.associatedMuscleGroups = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(muscleGroups)));
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getFunctionDescription() {
        return functionDescription;
    }

    public Set<MuscleGroup> getAssociatedMuscleGroups() {
        return associatedMuscleGroups;
    }
}
