package net.therap.service;

import net.therap.dao.UserDao;
import net.therap.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/9/14
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService {
    @Autowired
    @Qualifier ("userDaoJPA")
    private UserDao userDao;

    public List<User> getUserList() {
       return userDao.getUserList();
    }
}
