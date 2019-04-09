package dao;

import model.User;

import java.util.*;

import java.io.*;

import org.apache.ibatis.session.SqlSession;

public class UserDaoMybatis implements UserDao {
    
    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    
    public int insertUser(User user) {
        return this.sqlSession.insert("mapper.UserMapper.insertUser", user);
    }

    public int updateUser(User user) {
        int result = 0;

        return result;
    }

    public int deleteUser(User user) {
        int result = 0;

        return result;
    }

    public int countUser(String userId) {
        return this.sqlSession.selectOne("mapper.UserMapper.countUser", userId);
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