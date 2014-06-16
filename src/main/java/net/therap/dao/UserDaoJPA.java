package net.therap.dao;

import net.therap.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/9/14
 * Time: 1:00 PM
 */
@Repository
@Qualifier ("userDaoJpa")
public class UserDaoJPA implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUserList() {
        Query query = entityManager.createQuery("FROM User ");
        return query.getResultList();
    }

    private void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    public User getUserById(String id) {
        return entityManager.find(User.class, "sujon");
    }

}
