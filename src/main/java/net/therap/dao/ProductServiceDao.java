package net.therap.dao;

import net.therap.domain.Service;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/18/14
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ProductServiceDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Service> getProductServiceList() {
        return entityManager.createQuery("From Service").getResultList();
    }
}
