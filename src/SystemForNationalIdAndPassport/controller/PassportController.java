package controller;

import model.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PassportController {


    public boolean create(String firstName, String lastName, int id, Date dob,
            Gender gender, BlType bloodType, Date expDate) {
        var isPassportExistInApproved = Data.approvedPassport
                .stream().anyMatch(passport -> passport.getId()==id);
        var isPassportExistInNonApproved = Data.nonApprovedPassport
                .stream().anyMatch(passport -> passport.getPassport().getId()==id);
        if (isPassportExistInApproved || isPassportExistInNonApproved){
            System.out.println("This Passport id exist");
            return false;
        }
        Passport newPassport= new Passport(firstName, lastName, id, dob, gender, bloodType, expDate);
        Data.nonApprovedPassport.add(new PassportApprovingStatus(newPassport,RequestType.CREATE,Approving.Waiting));
        return Data.saveNonApprovedPassport();
    }

    public boolean renew() {
        //after
        return false;
    }

    public boolean acceptPassport(int id){
        var isPassportExistInNonApproved = Data.nonApprovedPassport
                .stream()
                .filter(passportApprovingStatus -> passportApprovingStatus.getPassport().getId()==id)
                .findFirst();
        if (isPassportExistInNonApproved.isEmpty()){
            System.out.println("This passport id not exist");
            return false;
        }else{
            var indexOfPassport = Data.nonApprovedPassport.indexOf(isPassportExistInNonApproved.get());
            Data.approvedPassport.add(Data.nonApprovedPassport.get(indexOfPassport).getPassport());
            Data.nonApprovedPassport.remove(indexOfPassport);
            return Data.saveApprovedPassport() && Data.saveNonApprovedPassport();
        }
    }

    public boolean rejectPassport(int id){
        var isPassportExistInNonApproved = Data.nonApprovedPassport
                .stream()
                .filter(passportApprovingStatus -> passportApprovingStatus.getPassport().getId()==id)
                .findFirst();
        if (isPassportExistInNonApproved.isEmpty()){
            System.out.println("This passport id not exist");
            return false;
        }else{
            var index = Data.nonApprovedPassport.indexOf(isPassportExistInNonApproved.get());
            var newPassportStatus = new PassportApprovingStatus(Data.nonApprovedPassport.get(index).getPassport(),
                    Data.nonApprovedPassport.get(index).getRequestType(),
                    Approving.Reject);
            Data.nonApprovedPassport.set(index,newPassportStatus);
            return Data.saveNonApprovedPassport();
        }
    }

    public List<String> showAllPassport() {
        return Data.approvedPassport.stream().map(Passport::toString).collect(Collectors.toList());

    }

    public Passport getPassportByPassportID(int id) {
        var isPassportExistInApproved = Data.approvedPassport
                .stream().filter(passport -> passport.getId()==id).findFirst();
        if (isPassportExistInApproved.isEmpty()){
            //check for null when this function is called
            return null;
        }{
            return isPassportExistInApproved.get();
        }
    }

    public List<String> showAllPendingPassport() {
        return Data.nonApprovedPassport.stream()
                .filter(passportApprovingStatus  -> passportApprovingStatus.getApprovingStatus() == Approving.Waiting)
                .map(PassportApprovingStatus::toString).collect(Collectors.toList());

    }

    public List<String> showAllRejectedPassport() {
        return Data.nonApprovedPassport.stream()
                .filter(passportApprovingStatus  -> passportApprovingStatus.getApprovingStatus() == Approving.Reject)
                .map(PassportApprovingStatus::toString).collect(Collectors.toList());

    }

    public List<String> showAllApprovedPassport() {
        return Data.approvedPassport.stream()
                .map(Passport::toString).collect(Collectors.toList());

    }
}
