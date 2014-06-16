package net.therap.dao;

import net.therap.controller.CompanyController;
import net.therap.domain.Company;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/16/14
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository
@Qualifier ("companyDaoJpa")
public class CompanyDaoJPA implements CompanyDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> getCompanyList() {
        Query query = entityManager.createQuery("FROM Company ");
        return query.getResultList();
    }

    @Override
    public void insertCompany(Company company) {
        entityManager.persist(company);
        entityManager.flush();
    }
}
