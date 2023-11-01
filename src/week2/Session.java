package week2;

import java.util.Date;

public class Session {
    private int sessionId;
    private Date date;
    private Member member;
    private Workout workout;
    private boolean isCompleted;
    private int sessionRPE; //rate of perceived exertion (1-10)

    public Session(int sessionId, Date date, Member member, Workout workout, boolean isCompleted, int sessionRPE) {
        this.sessionId = sessionId;
        this.date = date;
        this.member = member;
        this.workout = workout;
        this.isCompleted = isCompleted;
        this.sessionRPE = sessionRPE;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
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
                "sessionId=" + sessionId +
                ", date=" + date +
                ", member=" + member +
                ", workout=" + workout +
                ", isCompleted=" + isCompleted +
                ", sessionRPE=" + sessionRPE +
                '}';
    }
}
