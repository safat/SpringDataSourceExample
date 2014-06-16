package net.therap.service;

import net.therap.dao.CompanyDao;
import net.therap.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/16/14
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class CompanyService {
    @Autowired
    @Qualifier("companyDaoJpa")
    CompanyDao companyDao;

    public List<Company> getCompanyList(){
        return companyDao.getCompanyList();
    }

    public void insertCompany(Company company) {
        companyDao.insertCompany(company);
    }
}
