package model;

import java.io.Serializable;

public class NationalIDApprovingStatus implements Serializable {
    private NationalID nationalID;
    private RequestType requestType;
    private Approving approvingStatus;

    public NationalIDApprovingStatus(NationalID nationalID, RequestType requestType, Approving approvingStatus) {
        this.nationalID = nationalID;
        this.requestType = requestType;
        this.approvingStatus = approvingStatus;
    }

    public NationalID getNationalID() {
        return nationalID;
    }

    public void setNationalID(NationalID nationalID) {
        this.nationalID = nationalID;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public Approving getApprovingStatus() {
        return approvingStatus;
    }

    public void setApprovingStatus(Approving approvingStatus) {
        this.approvingStatus = approvingStatus;
    }
}
