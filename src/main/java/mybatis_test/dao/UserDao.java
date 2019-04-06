package dao;

import model.User;

import java.util.*;

public interface UserDao {
    public int insertUser(User user);
    public int updateUser(User user);
    public int deleteUser(User user);
    public int countUser(String userId);
    public int countAll();
    public User getUser(String userId);
    public List<User> selectAll();
}