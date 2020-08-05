package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Agent implements Serializable {
    private String agentId;
    private String companyId;
    private LocalDate entryDate;
    private String phoneNo;
    private String email;
    private String name;

    @Override
    public String toString() {
        return "Agent{" +
                "agentId='" + agentId + '\'' +
                ", companyId='" + companyId + '\'' +
                ", entryDate=" + entryDate +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Agent() {
    }

    public Agent(String agentId, String companyId, LocalDate entryDate, String phoneNo, String email, String name) {
        this.agentId = agentId;
        this.companyId = companyId;
        this.entryDate = entryDate;
        this.phoneNo = phoneNo;
        this.email = email;
        this.name = name;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
