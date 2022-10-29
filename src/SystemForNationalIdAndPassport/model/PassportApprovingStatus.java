package SystemForNationalIdAndPassport.model;

import java.io.Serializable;

public class PassportApprovingStatus implements Serializable {
    private Passport passport;
    private RequestType requestType;
    private Approving approvingStatus;

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
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
