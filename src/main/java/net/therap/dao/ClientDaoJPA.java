package net.therap.dao;

import net.therap.domain.Client;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/17/14
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Qualifier ("clientDaoJpa")
public class ClientDaoJPA implements ClientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> getClientList() {
        javax.persistence.Query query = entityManager.createQuery("FROM Client");
        return query.getResultList();
    }
}
