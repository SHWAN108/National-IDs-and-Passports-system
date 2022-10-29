package SystemForNationalIdAndPassport.controller;

import SystemForNationalIdAndPassport.model.NationalID;
import SystemForNationalIdAndPassport.model.NationalIDApprovingStatus;

import java.util.ArrayList;

public class NationalIDController {
    public static ArrayList<NationalID> approvedNationalId = new ArrayList<>();
    public static ArrayList<NationalIDApprovingStatus> nonApprovedNationalId = new ArrayList<>();

    public boolean create(){
        return false;
    }

    public boolean update()
    {
        return false;
    }

    public boolean renew(){
        return false;
    }

    public ArrayList<String> showAllNationalId(){
        return null;
    }

    public NationalID getNationalId(int nationalId){
        return null;
    }

    public ArrayList<String> showAllPendingNationalId(){
        return null;
    }

    public ArrayList<String> showAllRejectedNationalId(){
        return null;
    }

    public ArrayList<String> showAllApprovedNationalId(){
        return null;
    }



    public boolean leadAllDataToList(){
        return false;
    }

    public boolean saveListToFile(){
        return false;
    }



}