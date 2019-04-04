package dao;

import model.User;

import java.util.*;

import java.sql.*;

public class UserDaoJdbc implements UserDao {

    public int insertUser(User user) {
        return 0;
    }

    public int updateUser(User user) {
        return 0;
    }

    public int deleteUser(User user) {
        return 0;
    }

    public int countUser(String userId) {
        return 0;
    }

    public int countAll() {
        return 0;
    }

    public User getUser(String userId) {
        return null;
    }

    public List<User> selectAll() {
        throw new UnsupportedOperationException("유효한 호출이 아닙니다.");
    }

    public List<User> selectCondition(Object ...obj) {
        throw new UnsupportedOperationException("유효한 호출이 아닙니다.");
    }
}