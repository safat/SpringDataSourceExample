package net.therap.dao;

import net.therap.domain.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/17/14
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Qualifier("studentDaoJpa")
public class StudentDaoJPA implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getStudentList() {
        Query query = entityManager.createQuery("FROM Student");
        return query.getResultList();
    }
}
