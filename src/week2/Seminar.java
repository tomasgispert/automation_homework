package week2;

import java.util.ArrayList;
import java.util.Date;

public class Seminar implements Certifiable{
    private int seminarId;
    private String name;
    private Date date;
    private double estimatedDuration;
    private Instructor instructor;
    private ArrayList<Person> attendees;
    private String description;

    public Seminar(int seminarId, String name, Date date, double estimatedDuration, Instructor instructor, ArrayList<Person> attendees, String description) {
        this.seminarId = seminarId;
        this.name = name;
        this.date = date;
        this.estimatedDuration = estimatedDuration;
        this.instructor = instructor;
        this.attendees = attendees;
        this.description = description;
    }

    public int getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(int seminarId) {
        this.seminarId = seminarId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(double estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public ArrayList<Person> getAttendees() {
        return attendees;
    }

    public void setMembers(ArrayList<Person> attendees) {
        this.attendees = attendees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Seminar{" +
                "seminarId=" + seminarId +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", estimatedDuration=" + estimatedDuration +
                ", instructor=" + instructor +
                ", members=" + attendees +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean isCertified() {
        return this.getInstructor().isCertified();
    }
}
