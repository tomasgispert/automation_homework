package main.java.com.solvd.automation_homework;

import java.util.Date;
import java.util.List;

public class Session implements IVolume {
    private Date date;
    private Member member;
    private Workout workout;
    protected int sessionRPE; //rate of perceived exertion (1-10)

    public Session(Date date, Member member, Workout workout) {
        this.date = date;
        this.member = member;
        this.workout = workout;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public int getSessionRPE() {
        return sessionRPE;
    }

    public void setSessionRPE(int sessionRPE) {
        this.sessionRPE = sessionRPE;
    }

    @Override
    public String toString() {
        return "Session{" +
                "date=" + date +
                ", member=" + member +
                ", workout=" + workout +
                ", sessionRPE=" + sessionRPE +
                '}';
    }

    @Override
    public double getVolume() {
        double volume = 0;
        List<Exercise> sets = this.getWorkout().getExercises();
        for (int i = 0; i < sets.size()-1; i++) {
            if(sets.get(i) instanceof Set) {
                Set set = (Set) sets.get(i);
                volume = set.getVolume() + volume;
            }
        }
        return volume;
    }
}
