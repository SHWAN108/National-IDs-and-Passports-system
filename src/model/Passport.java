package model;

import java.io.Serializable;
import java.util.*;

public class Passport implements Serializable {

    String firstName;
    String lastName;
    int id;
    Date dob;
    Gender gender;
    BlType bloodType;
    Date expDate;

    public Passport(String firstName, String lastName, int id, Date dob,
            Gender gender, BlType bloodType, Date expDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.dob = dob;
        this.gender = gender;
        this.bloodType = bloodType;
        this.expDate = expDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BlType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BlType bloodType) {
        this.bloodType = bloodType;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

}
