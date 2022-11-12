package controller;

import model.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class NationalIDController {
    public boolean create(String firstName, String lastName, int nationalId, Date dob,
            Gender gender, BlType bloodType, Date expDate) {
        var isNationalIdExistInApproved = Data.approvedNationalId
                .stream().anyMatch(nationalID -> nationalID.getNationalId()==nationalId);
        var isNationalIdExistInNonApproved = Data.nonApprovedNationalId
                .stream().anyMatch(nationalID -> nationalID.getNationalID().getNationalId()==nationalId);
        if (isNationalIdExistInApproved || isNationalIdExistInNonApproved){
            System.out.println("This NationalId exist");
            return false;
        }
        NationalID newPassport= new NationalID(firstName, lastName, nationalId, dob, gender, bloodType, expDate);
        Data.nonApprovedNationalId.add(new NationalIDApprovingStatus(newPassport, RequestType.CREATE,Approving.Waiting));
        return Data.saveNonApprovedNationalId();
    }

    public boolean update(String firstName, Date expDate, int nationalId) {
        var isNationalIdExistInApproved = Data.approvedNationalId
                .stream().filter(nationalID -> nationalID.getNationalId()==nationalId).findFirst();
        if (isNationalIdExistInApproved.isEmpty()){
            System.out.println("This national id not exist");
            return false;
        }
        var indexOfNationalId = Data.approvedNationalId.indexOf(isNationalIdExistInApproved.get());
        var newNationalId = new NationalID(
                firstName,
                isNationalIdExistInApproved.get().getLastName(),
                nationalId,
                isNationalIdExistInApproved.get().getDob(),
                isNationalIdExistInApproved.get().getGender(),
                isNationalIdExistInApproved.get().getBloodType(),
                expDate);
        //still need fix
        Data.approvedNationalId.set(indexOfNationalId,newNationalId);
        return Data.saveApprovedNationalId();
    }

    public boolean acceptNationalId(int nationalId){
        var isNationalIdExistInNonApproved = Data.nonApprovedNationalId
                .stream()
                .filter(nationalIDApprovingStatus -> nationalIDApprovingStatus.getNationalID().getNationalId()==nationalId)
                .findFirst();
        if (isNationalIdExistInNonApproved.isEmpty()){
            System.out.println("This national id not exist");
            return false;
        }else{
            var indexOfNationalId = Data.nonApprovedNationalId.indexOf(isNationalIdExistInNonApproved.get());
            Data.approvedNationalId.add(Data.nonApprovedNationalId.get(indexOfNationalId).getNationalID());
            Data.nonApprovedNationalId.remove(indexOfNationalId);
            return Data.saveApprovedNationalId() && Data.saveNonApprovedNationalId();
        }
    }

    public boolean rejectNationalId(int nationalId){
        var isNationalIdExistInNonApproved = Data.nonApprovedNationalId
                .stream()
                .filter(nationalIDApprovingStatus -> nationalIDApprovingStatus.getNationalID().getNationalId()==nationalId)
                .findFirst();
        if (isNationalIdExistInNonApproved.isEmpty()){
            System.out.println("This national id not exist");
            return false;
        }else{
            var index = Data.nonApprovedNationalId.indexOf(isNationalIdExistInNonApproved.get());
            var newNationalIdStatus = new NationalIDApprovingStatus(Data.nonApprovedNationalId.get(index).getNationalID(),
                    Data.nonApprovedNationalId.get(index).getRequestType(),
                    Approving.Reject);
            Data.nonApprovedNationalId.set(index,newNationalIdStatus);
            return Data.saveNonApprovedNationalId();
        }
    }

    public List<String> getAllNationalIds() {
        Data.fetchApprovedNationalId();
        return Data.approvedNationalId.stream().map(NationalID::toString).collect(Collectors.toList());
    }

    public NationalID getNationalId(int nationalId) {
        var isNationalIdExistInApproved = Data.approvedNationalId
                .stream().filter(nationalID -> nationalID.getNationalId()==nationalId).findFirst();
        if (isNationalIdExistInApproved.isEmpty()){
            //check for null when this function is called
            return null;
        }{
            return isNationalIdExistInApproved.get();
        }
    }

    //implement toString method for nationalIdStatus
    public List<String> showAllWaitingNationalId() {
        return Data.nonApprovedNationalId.stream()
                .filter(nationalIDApprovingStatus -> nationalIDApprovingStatus.getApprovingStatus() == Approving.Waiting)
                .map(NationalIDApprovingStatus::toString).collect(Collectors.toList());

    }

    public List<String> showAllRejectedNationalId() {
        return Data.nonApprovedNationalId.stream()
                .filter(nationalIDApprovingStatus -> nationalIDApprovingStatus.getApprovingStatus() == Approving.Reject)
                .map(NationalIDApprovingStatus::toString).collect(Collectors.toList());
    }

    public List<String> showAllApprovedNationalId() {
        return Data.approvedNationalId.stream()
                .map(NationalID::toString).collect(Collectors.toList());
    }

}
