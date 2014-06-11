package net.therap.dao;

import net.therap.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
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
    private EntityManager em;

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public List<User> getUserList() {
//        Session session = sessionFactory.getCurrentSession();
//        Criteria criteria = session.createCriteria(User.class);
//        List<User> userList = criteria.list();
//        return userList;
        List<User> userList = em.createQuery("FROM User").getResultList();
        return userList;
    }
}
