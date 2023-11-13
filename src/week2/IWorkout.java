package week2;

public interface IWorkout{
    Session completeSession(Workout workout,int rpe) throws InvalidIntensityException;
}
