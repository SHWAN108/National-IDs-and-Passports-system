package SystemForNationalIdAndPassport.model;

import java.io.Serializable;
import java.util.*;

public class NationalID implements Serializable {
    String firstName;
    String lastName;
    int nationalId;
    Date dob;
    Gender gender;
    BlType bloodType;
    Date expDate;

    public NationalID(String firstName, String lastName, int nationalId, Date dob,
            Gender gender, BlType bloodType, Date expDate) {
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.nationalId = nationalId;
            this.dob = dob;
            this.gender = gender;
            this.bloodType = bloodType;
            this.expDate = expDate;
        }
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

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
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
