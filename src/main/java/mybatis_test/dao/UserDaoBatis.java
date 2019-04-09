package dao;

import model.User;
import connection.*;

import java.util.*;

import java.sql.*;

public class UserDaoBatis implements UserDao {

    public int insertUser(User user) {
        return 0;
    }

    public int updateUser(User user) {
        return 0;
    }

    public int deleteUser(User user) {
        return this.deleteUser(user.getUserId());
    }

    private int deleteUser(String userId) {
        return 0;
    }

    public int countUser(String userId) {
        return 0;
    }

    public int countAll() {
        return 0;
    }

    public User getUser(String userId) {
        User user = new User();

        
        return user;
    }

    public List<User> selectAll() {
       
        List<User> list = new ArrayList<User>();
        
        return list;
    }

    public void deleteAll() {
        
    }

}