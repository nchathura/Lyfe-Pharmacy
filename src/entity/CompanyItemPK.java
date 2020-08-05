package entity;

public class CompanyItemPK {
    private String ItemCode;
    private String companyId;

    @Override
    public String toString() {
        return "CompanyItemPK{" +
                "ItemCode='" + ItemCode + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }

    public CompanyItemPK() {
    }

    public CompanyItemPK(String itemCode, String companyId) {
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
