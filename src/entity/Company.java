package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Company implements Serializable {
    private String companyId;
    private String companyName;
    private LocalDate entryDate;
    private String companyPhoneNo;
    private String companyEmail;

    @Override
    public String toString() {
        return "Company{" +
                "companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", entryDate=" + entryDate +
                ", companyPhoneNo='" + companyPhoneNo + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                '}';
    }

    public Company() {
    }

    public Company(String companyId, String companyName, LocalDate entryDate, String companyPhoneNo, String companyEmail) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.entryDate = entryDate;
        this.companyPhoneNo = companyPhoneNo;
        this.companyEmail = companyEmail;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getCompanyPhoneNo() {
        return companyPhoneNo;
    }

    public void setCompanyPhoneNo(String companyPhoneNo) {
        this.companyPhoneNo = companyPhoneNo;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }
}
