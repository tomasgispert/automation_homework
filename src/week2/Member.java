package week2;

import java.util.Date;

public class Member extends Person{
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
}
