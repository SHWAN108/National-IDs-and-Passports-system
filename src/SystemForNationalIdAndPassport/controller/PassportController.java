package SystemForNationalIdAndPassport.controller;

import SystemForNationalIdAndPassport.model.NationalID;
import SystemForNationalIdAndPassport.model.Passport;

import java.util.ArrayList;

public class PassportController {
    public static ArrayList<Passport> approvedPassport = new ArrayList<>();
    public static ArrayList<Passport> nonApprovedPassport = new ArrayList<>();

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

    public ArrayList<String> showAllPassport(){
        return null;
    }

    public NationalID getPassportByPassportID(int nationalId){
        return null;
    }

    public ArrayList<String> showAllPendingPassport(){
        return null;
    }

    public ArrayList<String> showAllRejectedPassport(){
        return null;
    }

    public ArrayList<String> showAllApprovedPassport(){
        return null;
    }



    public boolean leadAllDataToList(){
        return false;
    }

    public boolean saveListToFile(){
        return false;
    }
}
