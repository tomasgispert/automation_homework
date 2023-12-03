package com.solvd.automation_homework;

import java.util.Date;

public class Member extends Person implements IWorkout{
    private String fitnessGoals;
    private Membership membership;

    public Member(int memberId, String name, Date birthday,String contactInfo, String fitnessGoals, Membership membership) {
        super(memberId,name,birthday,contactInfo);
        this.fitnessGoals = fitnessGoals;
        this.membership = membership;
    }
    public String getFitnessGoals() {
        return fitnessGoals;
    }

    public void setFitnessGoals(String fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + this.getPersonId() +
                ", name='" + this.getName() + '\'' +
                ", birthday=" + this.getBirthday() +
                ", fitnessGoals='" + fitnessGoals + '\'' +
                ", contactInfo='" + this.getContactInfo() + '\'' +
                ", membership=" + membership +
                '}';
    }

    @Override
    public void introduceMyself() {
        System.out.println("Hello, my name is "
                +this.getName()+" and my goal training here is "
                +this.getFitnessGoals());
    }

    @Override
    public Payment makePayment(double amount, String month, String paymentMethod) throws InsufficientMoneyException {
        if(amount >= this.getMembership().getCost()){
            return new Payment(new Date(),month,amount,this,paymentMethod);
        }else{
            throw new InsufficientMoneyException("The amount is not enough to cover the Membership");
        }

    }

    @Override
    public Session completeSession(Workout workout, int rpe) throws InvalidIntensityException {
        if(rpe > 0 && rpe <= 10){
            Session completedSession = new Session(new Date(),this,workout);
            completedSession.setSessionRPE(rpe);
            return completedSession;
        }else{
            throw new InvalidIntensityException("Rate of perceived exertion is invalid");
        }
    }
}
