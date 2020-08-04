package util;

import java.sql.Date;
import java.time.LocalDate;

public class AgentTM {
    private String agentId;
    private String name;
    private String phoneNo;
    private LocalDate entryDate;
    private String email;
    private String companyId;

    @Override
    public String toString() {
        return "AgentTM{" +
                "agentId='" + agentId + '\'' +
                ", name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", entryDate=" + entryDate +
                ", email='" + email + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }



    public AgentTM() {
    }



    public AgentTM(String agentId, String name, String phoneNo, LocalDate entryDate, String email, String companyId) {
        this.agentId = agentId;
        this.name = name;
        this.phoneNo = phoneNo;
        this.entryDate = entryDate;
        this.email = email;
        this.companyId = companyId;
    }



    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
