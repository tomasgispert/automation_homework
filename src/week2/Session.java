package week2;

import java.util.ArrayList;
import java.util.Date;

public class Session implements IVolume {
    private Date date;
    private Member member;
    private Workout workout;
    protected int sessionRPE; //rate of perceived exertion (1-10)

    public Session(Date date, Member member, Workout workout, int sessionRPE) {
        this.date = date;
        this.member = member;
        this.workout = workout;
        this.sessionRPE = sessionRPE;
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
        ArrayList<Exercise> sets = this.getWorkout().getExercises();
        for (int i = 0; i < sets.size()-1; i++) {
            if(sets.get(i) instanceof Set) {
                Set set = (Set) sets.get(i);
                volume = set.getVolume() + volume;
            }
        }
        return volume;
    }
}
