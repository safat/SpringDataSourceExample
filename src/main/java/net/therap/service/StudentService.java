package net.therap.service;

import net.therap.dao.StudentDao;
import net.therap.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/17/14
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class StudentService {

    @Autowired
    @Qualifier("studentDaoJpa")
    private StudentDao studentDao;

    public List<Student> getStudentList(){
        return studentDao.getStudentList();
    }
}
