package dao;

import entity.CompanyItem;
import entity.CompanyItemPK;

import java.util.List;

public interface CompanyItemDAO {
    public List<CompanyItem> getAllCompanyItems();
    public  CompanyItem getCompanyItem(CompanyItemPK companyItemPK);
    public  boolean saveCompanyItem(CompanyItem companyItem);
    public  boolean deleteCompanyItem(CompanyItemPK companyItemPK);
    public  boolean updateCompanyItem(CompanyItem companyItem)


}
