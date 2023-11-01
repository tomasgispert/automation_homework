package week2;

import java.util.Date;
import java.util.Objects;

public class Member {
    private int memberId;
    private String name;
    private Date birthday;
    private String fitnessGoals;
    private String contactInfo;
    private Membership membership;

    public Member(int memberId, String name, Date birthday, String fitnessGoals, String contactInfo, Membership membership) {
        this.memberId = memberId;
        this.name = name;
        this.birthday = birthday;
        this.fitnessGoals = fitnessGoals;
        this.contactInfo = contactInfo;
        this.membership = membership;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFitnessGoals() {
        return fitnessGoals;
    }

    public void setFitnessGoals(String fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
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
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", fitnessGoals='" + fitnessGoals + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", membership=" + membership +
                '}';
    }
}
