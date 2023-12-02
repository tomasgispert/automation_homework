package com.solvd.automation_homework;

import java.util.Date;
import java.util.Objects;

public abstract class Person implements IPay{
    private int personId;
    private String name;
    private Date birthday;
    private String contactInfo;
    private double weight;
    private int height;

    public Person(int personId, String name, Date birthday, String contactInfo) {
        this.personId = personId;
        this.name = name;
        this.birthday = birthday;
        this.contactInfo = contactInfo;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract void introduceMyself();

    public final double calculateBMI() {
        return this.weight / (this.height * this.height);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return personId == person.personId && Objects.equals(name, person.name) && Objects.equals(birthday, person.birthday) && Objects.equals(contactInfo, person.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, name, birthday, contactInfo);
    }
}
