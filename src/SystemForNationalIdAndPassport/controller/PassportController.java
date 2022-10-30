package SystemForNationalIdAndPassport.controller;

import SystemForNationalIdAndPassport.model.BlType;
import SystemForNationalIdAndPassport.model.Gender;
import SystemForNationalIdAndPassport.model.NationalID;
import SystemForNationalIdAndPassport.model.Passport;

import java.util.ArrayList;
import java.util.Date;

public class PassportController {
    public static ArrayList<Passport> approvedPassport = new ArrayList<>();
    public static ArrayList<Passport> nonApprovedPassport = new ArrayList<>();

    public boolean create(String firstName, String lastName, int id, Date dob,
            Gender gender, BlType bloodType, Date expDate) {
        Passport shwan = new Passport(firstName, lastName, id, dob, gender, bloodType, expDate);
        approvedPassport.add(shwan);
        return false;
    }

    public boolean renew() {
        return false;
    }

    public ArrayList<Passport> showAllPassport() {
        approvedPassport.stream().forEach(System.out::println);
        return approvedPassport;

    }

    public NationalID getPassportByPassportID(int nationalId) {
        return null;
    }

    public ArrayList<Passport> showAllPendingPassport() {
        approvedPassport.stream().forEach(System.out::println);
        return nonApprovedPassport;

    }

    public ArrayList<Passport> showAllRejectedPassport() {
        nonApprovedPassport.stream().forEach(System.out::println);
        return nonApprovedPassport;

    }

    public ArrayList<Passport> showAllApprovedPassport() {
        approvedPassport.stream().forEach(System.out::println);
        return approvedPassport;

    }

    public boolean leadAllDataToList() {
        return false;
    }

    public boolean saveListToFile() {
        return false;
    }
}
