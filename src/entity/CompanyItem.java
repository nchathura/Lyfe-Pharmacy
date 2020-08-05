package entity;

import java.io.Serializable;

public class CompanyItem implements Serializable {
     private CompanyItemPK companyItemPK;

    public CompanyItem() {
    }

    public CompanyItem(String itemCode, String companyId) {
        this.companyItemPK = new CompanyItemPK(itemCode,companyId);
    }

    public CompanyItem(CompanyItemPK companyItemPK) {
        this.companyItemPK = companyItemPK;
    }


    public CompanyItemPK getCompanyItemPK() {
        return companyItemPK;
    }

    public void setCompanyItemPK(CompanyItemPK companyItemPK) {
        this.companyItemPK = companyItemPK;
    }
}
