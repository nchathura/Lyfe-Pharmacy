package entity;

import java.io.Serializable;

public class CompanyItemPK implements Serializable {
    private String itemCode;
    private String companyId;

    @Override
    public String toString() {
        return "CompanyItemPK{" +
                "ItemCode='" + itemCode + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }

    public CompanyItemPK() {
    }

    public CompanyItemPK(String itemCode, String companyId) {
        this.itemCode = itemCode;
        this.companyId = companyId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
