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
        return this.sqlSession.update("mapper.UserMapper.updateUser", user);
    }

    public int deleteUser(User user) {
        return this.sqlSession.delete("mapper.UserMapper.deleteUser", user.getUserId());
    }

    public int countUser(String userId) {
        return this.sqlSession.selectOne("mapper.UserMapper.countUser", userId);
    }

    public int countAll() {
        return this.sqlSession.selectOne("mapper.UserMapper.countAllUser");
    }

    public User getUser(String userId) {
        return this.sqlSession.selectOne("mapper.UserMapper.selectUser", userId);
    }

    public List<User> selectAll() {
        List<User> list = new ArrayList<User>();

        return list;
    }

    public void deleteAll() {
        this.sqlSession.delete("mapper.UserMapper.deleteUserAll");
    }
}