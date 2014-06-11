package net.therap.dao;

import net.therap.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/9/14
 * Time: 1:00 PM
 */
@Repository
@Qualifier ("userDao")
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getUserList() {
//        Session session = sessionFactory.getCurrentSession();
//        Criteria criteria = session.createCriteria(User.class);
//        List<User> userList = criteria.list();
//        return userList;
        List<User> userList = entityManager.createQuery("FROM User AS U where U.name = 'user' ").getResultList();
        return userList;
    }
}
