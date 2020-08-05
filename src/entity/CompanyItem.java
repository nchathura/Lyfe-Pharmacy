package entity;

public class CompanyItem {
     private String ItemCode;
     private String companyId;

    @Override
    public String toString() {
        return "CompanyItem{" +
                "ItemCode='" + ItemCode + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }

    public CompanyItem() {
    }

    public CompanyItem(String itemCode, String companyId) {
        ItemCode = itemCode;
        this.companyId = companyId;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
