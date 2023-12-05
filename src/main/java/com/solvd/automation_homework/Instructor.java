package com.solvd.automation_homework;

import com.solvd.enums.PaymentMethod;

import java.util.List;
import java.util.Date;

public class Instructor extends Person implements Certifiable{
    private String expertise;
    private boolean isCertified;
    private List<Exercise> topThreeExercises;

    public Instructor(int instructorId, String name, Date birthday, String contactInfo, String expertise, boolean isCertified, List<Exercise> topThreeExercises) {
        super(instructorId,name,birthday,contactInfo);
        this.expertise = expertise;
        this.isCertified = isCertified;
        this.topThreeExercises = topThreeExercises;
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

    public List<Exercise> getTopThreeExercises() {
        return topThreeExercises;
    }

    public void setTopThreeExercises(List<Exercise> topThreeExercises) {
        this.topThreeExercises = topThreeExercises;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorId=" + this.getPersonId() +
                ", name='" + this.getName() + '\'' +
                ", expertise='" + expertise + '\'' +
                ", isCertified=" + isCertified +
                ", contactInfo='" + this.getContactInfo() + '\'' +
                ", topThreeExercises=" + topThreeExercises +
                '}';
    }

    @Override
    public void introduceMyself() {
        System.out.println("Hi, my name is "+this.getName()
                +", I'm an Instructor and this are my top 3 favourite exercises: "
                +this.getTopThreeExercises().get(0).getName()+", "
                +this.getTopThreeExercises().get(1).getName()+" and "
                +this.getTopThreeExercises().get(2).getName());
    }

    @Override
    public Payment makePayment(double amount, String month,PaymentMethod method) {
        return new Payment(new Date(),month,0,this, PaymentMethod.STAFF.getMethod());
    }

    public Exercise createExercise(String name, String description, List<Muscle> musclesWorked, List<Equipment> equipmentRequired) throws MissingEquipmentException {
        boolean isAvailable = true;
        for (int i = 0; i < equipmentRequired.size()-1; i++) {
            isAvailable = equipmentRequired.get(i).isAvailable();
            if(!isAvailable){
                break;
            }
        }
        if(isAvailable){
            return new Exercise(name,description,musclesWorked,equipmentRequired);
        }else{
            throw new MissingEquipmentException("The equipment requirements cannot be met at the moment");
        }
    }
}
