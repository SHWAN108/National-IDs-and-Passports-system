package SystemForNationalIdAndPassport.model;

import java.util.*;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private int id;
    private int password;
    private String email;
    private Date dob;
    private Gender gender;
    private Position position;
    private BlType bloodType;

    public User() {

    }

    public User(String firstName, String lastName, int age, int id, int password, String email, Date dob,
            Gender gender, Position position, BlType bloodType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.position = position;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public BlType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BlType bloodType) {
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", id=" + id + ", password="
                + password + ", email=" + email + ", dob=" + dob + ", gender=" + gender + ", position=" + position
                + ", bloodType=" + bloodType + "]";
    }

}