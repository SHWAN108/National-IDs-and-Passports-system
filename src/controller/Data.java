package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<NationalID> approvedNationalId = new ArrayList<>();
    public static List<NationalIDApprovingStatus> nonApprovedNationalId = new ArrayList<>();

    public static List<Passport> approvedPassport = new ArrayList<>();
    public static List<PassportApprovingStatus> nonApprovedPassport = new ArrayList<>();

    public static List<User> users = new ArrayList<>();

    private static SaveListToFile<NationalID> saveApprovedNationalIdToList = new SaveListToFile<>(
            "files/approvedNationalId.txt");
    private static SaveListToFile<NationalIDApprovingStatus> saveNonApprovedNationalIdToList = new SaveListToFile<>(
            "files/nonApprovedNationalId.txt");

    private static SaveListToFile<Passport> saveApprovedPassport = new SaveListToFile<>("files/approvedPassport.txt");
    private static SaveListToFile<PassportApprovingStatus> saveNonApprovedPassport = new SaveListToFile<>(
            "files/nonApprovedPassport.txt");

    private static SaveListToFile<User> saveUsers = new SaveListToFile<>("files/users.txt");

    public static void fetchApprovedNationalId() {
        approvedNationalId = saveApprovedNationalIdToList.openList();
    }

    public static boolean saveApprovedNationalId() {
        return saveApprovedNationalIdToList.saveListToFile(approvedNationalId);
    }

    public static void fetchNonApprovedNationalId() {
        nonApprovedNationalId = saveNonApprovedNationalIdToList.openList();
    }

    public static boolean saveNonApprovedNationalId() {
        return saveNonApprovedNationalIdToList.saveListToFile(nonApprovedNationalId);
    }

    public static void fetchApprovedPassport() {
        approvedPassport = saveApprovedPassport.openList();
    }

    public static boolean saveApprovedPassport() {
        return saveApprovedPassport.saveListToFile(approvedPassport);
    }

    public static void fetchNonApprovedPassport() {
        nonApprovedPassport = saveNonApprovedPassport.openList();
    }

    public static boolean saveNonApprovedPassport() {
        return saveNonApprovedPassport.saveListToFile(nonApprovedPassport);
    }

    public static void fetchUsers() {
        users = saveUsers.openList();
    }

    public static boolean saveUser() {
        return saveUsers.saveListToFile(users);
    }

    public static void fetchAndSetAllData() {
        fetchUsers();
        fetchApprovedNationalId();
        fetchApprovedPassport();
        fetchNonApprovedPassport();
        fetchNonApprovedNationalId();
    }

}
