package net.therap.dao;

import net.therap.domain.Company;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/16/14
 * Time: 3:26 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CompanyDao {
    public List<Company> getCompanyList();
    public void insertCompany(Company company);
    void deleteCompanyById(int id);
    public Company getCompanyById(int id);
}
