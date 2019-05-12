package dao;

import model.User;
import java.util.*;
import org.apache.ibatis.session.SqlSession;

import mapper.*;

public class UserDaoMybatis implements UserDao {
    
    private SqlSession sqlSession;

    private UserMapperImpl userMapper;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        this.userMapper = sqlSession.getMapper(UserMapperImpl.class);
    }

    public int insertUser(User user) {
        // Interface 사용
        return this.userMapper.insertUser(user);
        // XML 사용
        // return this.sqlSession.insert("mapper.UserMapper.insertUser", user);
    }

    public int updateUser(User user) {
        // Interface 사용
        return this.userMapper.updateUser(user);
        // XML 사용
        // return this.sqlSession.update("mapper.UserMapper.updateUser", user);
    }

    public int deleteUser(User user) {
        // Interface 사용
        return this.userMapper.deleteUser(user);
        // XML 사용
        // return this.sqlSession.delete("mapper.UserMapper.deleteUser", user.getUserId());
    }

    public int countUser(String userId) {
        // Interface 사용
        return this.userMapper.countUser(userId);
        // XML 사용
        // return this.sqlSession.selectOne("mapper.UserMapper.countUser", userId);
    }

    public int countAll() {
        // Interface 사용
        return this.userMapper.countAllUser();
        // XML 사용
        // return this.sqlSession.selectOne("mapper.UserMapper.countAllUser");
    }

    public User getUser(String userId) {
        // Interface 사용
        return this.userMapper.getUser(userId);
        // XML 사용
        // return this.sqlSession.selectOne("mapper.UserMapper.selectUser", userId);
    }

    public List<User> selectAll() {
        // Interface 사용
        return this.userMapper.selectAll();
        // XML 사용
        // return this.sqlSession.selectList("mapper.UserMapper.selectUserAll");
    }

    public void deleteAll() {
        this.userMapper.deleteAll();
        // this.sqlSession.delete("mapper.UserMapper.deleteUserAll");
    }
}