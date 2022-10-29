package SystemForNationalIdAndPassport.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private int password;
    private Gender gender;
    private Role role;
    private String dob;
    private BlType bloodType;

    public User(String firstName, String lastName, int age, int id, int password, String userName, String dob,
            Gender gender, Role role, BlType bloodType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.dob = dob;
        this.gender = gender;
        this.role = role;
        this.bloodType = bloodType;
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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getPosition() {
        return role;
    }

    public void setPosition(Role role) {
        this.role = role;
    }

    public BlType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BlType bloodType) {
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", password="
                + password + ", email=" + userName + ", dob=" + dob + ", gender=" + gender + ", position=" + role
                + ", bloodType=" + bloodType + "]";
    }

}