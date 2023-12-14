package com.solvd.automation_homework;

import java.util.Date;

public class Session implements IVolume {
    private Date date;
    private Member member;
    private Workout workout;
    protected double sessionRPE; //rate of perceived exertion (1-10)

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

    public double getSessionRPE() {
        return sessionRPE;
    }

    public void setSessionRPE(double sessionRPE) {
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
        return this.getWorkout().getExercises().stream()
                .filter(exercise -> exercise instanceof WorkoutSet)
                .mapToDouble(exercise
                        -> ((WorkoutSet) exercise).getVolume()).sum();
    }
}
