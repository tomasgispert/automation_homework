package week2;

import java.util.ArrayList;

public class Instructor {
    private int instructorId;
    private String name;
    private String expertise;
    private boolean isCertified;
    private String contactInfo;
    private ArrayList<Exercise> topThreeExercises;

    public Instructor(int instructorId, String name, String expertise, boolean isCertified, String contactInfo, ArrayList<Exercise> topThreeExercises) {
        this.instructorId = instructorId;
        this.name = name;
        this.expertise = expertise;
        this.isCertified = isCertified;
        this.contactInfo = contactInfo;
        this.topThreeExercises = topThreeExercises;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public boolean isCertified() {
        return isCertified;
    }

    public void setCertified(boolean certified) {
        isCertified = certified;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ArrayList<Exercise> getTopThreeExercises() {
        return topThreeExercises;
    }

    public void setTopThreeExercises(ArrayList<Exercise> topThreeExercises) {
        this.topThreeExercises = topThreeExercises;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorId=" + instructorId +
                ", name='" + name + '\'' +
                ", expertise='" + expertise + '\'' +
                ", isCertified=" + isCertified +
                ", contactInfo='" + contactInfo + '\'' +
                ", topThreeExercises=" + topThreeExercises +
                '}';
    }
}
