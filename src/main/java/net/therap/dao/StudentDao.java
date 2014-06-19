package net.therap.dao;

import net.therap.domain.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/17/14
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
public interface StudentDao {
    public List<Student> getStudentList();
}
