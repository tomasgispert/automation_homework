package week2;

import java.util.ArrayList;
import java.util.Date;

public class Instructor extends Person implements Certifiable{
    private String expertise;
    private boolean isCertified;
    private ArrayList<Exercise> topThreeExercises;

    public Instructor(int instructorId, String name, Date birthday, String contactInfo, String expertise, boolean isCertified, ArrayList<Exercise> topThreeExercises) {
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

    public ArrayList<Exercise> getTopThreeExercises() {
        return topThreeExercises;
    }

    public void setTopThreeExercises(ArrayList<Exercise> topThreeExercises) {
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
                +" and I'm an Instructor and this are my favourite exercise is the "
                +this.getTopThreeExercises().get(0).getName());
    }

    @Override
    public Payment makePayment(double amount, String paymentMethod) {
        return new Payment(new Date(),0,this,"instructor");
    }

    public Exercise createExercise(String name, String description, ArrayList<Muscle> musclesWorked, ArrayList<Equipment> equipmentRequired) throws MissingEquipmentException {
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
