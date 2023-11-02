package week2;

import java.util.Date;

public abstract class Person {
    private int personId;
    private String name;
    private Date birthday;
    private String contactInfo;

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
    public abstract void introduceMyself();
}
