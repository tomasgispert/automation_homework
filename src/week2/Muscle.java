package week2;

public final class Muscle {
    private int muscleId;
    private final String name;
    private String description;
    private String primaryFunction;
    private boolean isMajorMuscle;

    public Muscle(int muscleId, String name, String description, String primaryFunction, boolean isMajorMuscle) {
        this.muscleId = muscleId;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrimaryFunction() {
        return primaryFunction;
    }

    public void setPrimaryFunction(String primaryFunction) {
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
                ", description='" + description + '\'' +
                ", primaryFunction='" + primaryFunction + '\'' +
                ", isMajorMuscle=" + isMajorMuscle +
                '}';
    }
}
