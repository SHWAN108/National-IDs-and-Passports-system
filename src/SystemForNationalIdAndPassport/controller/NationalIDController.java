package SystemForNationalIdAndPassport.controller;

import SystemForNationalIdAndPassport.model.BlType;
import SystemForNationalIdAndPassport.model.Gender;
import SystemForNationalIdAndPassport.model.NationalID;
import SystemForNationalIdAndPassport.model.NationalIDApprovingStatus;

import java.util.ArrayList;
import java.util.Date;

public class NationalIDController {
    public static ArrayList<NationalID> approvedNationalId = new ArrayList<>();
    public static ArrayList<NationalIDApprovingStatus> nonApprovedNationalId = new ArrayList<>();

    public boolean create(String firstName, String lastName, int nationalId, Date dob,
            Gender gender, BlType bloodType, Date expDate) {
        NationalID shwan = new NationalID(firstName, lastName, nationalId, dob, gender, bloodType, expDate);
        approvedNationalId.add(shwan);
        return false;
    }

    public boolean update(String firstName, Date expDate, int nationalId) {

        return false;
    }

    public ArrayList<NationalID> showAllNationalId() {
        approvedNationalId.stream().forEach(System.out::println);
        return approvedNationalId;
    }

    public NationalID getNationalId(int nationalId) {
        return getNationalId(nationalId);
    }

    public ArrayList<NationalIDApprovingStatus> showAllPendingNationalId() {
        approvedNationalId.stream().forEach(System.out::println);
        return nonApprovedNationalId;

    }

    public ArrayList<NationalIDApprovingStatus> showAllRejectedNationalId() {
        approvedNationalId.stream().forEach(System.out::println);
        return nonApprovedNationalId;
    }

    public ArrayList<NationalID> showAllApprovedNationalId() {
        approvedNationalId.stream().forEach(System.out::println);
        return approvedNationalId;
    }

    public boolean leadAllDataToList() {
        return false;
    }

    public boolean saveListToFile() {
        return false;
    }

}