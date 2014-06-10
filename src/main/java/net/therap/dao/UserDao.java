package net.therap.dao;

import net.therap.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/9/14
 * Time: 1:00 PM
 */
@Repository
@Qualifier("userDao")
public class UserDao extends HibernateDaoSupport {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getUserList() {
        String query = "SELECT id, name, password, is_admin FROM user";

        List<User> userList = jdbcTemplate.query(query, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getBoolean("is_admin"));
                return user;
            }
        });

        return userList;
    }
}
