package service;

import java.io.*;

import dao.*;

import model.User;
import service.exception.DuplicatedKeyException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import service.exception.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 단순하게 바로 Class로 만듦(원래는 Interface로 하는게 좋음)
 */
public class UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    private final static String RESOURCE_ORIGINAL = "mybatis-config.xml";
    private String resource = RESOURCE_ORIGINAL;

    private SqlSessionFactory sqlSessionFactory;

    private UserDaoMybatis userDao = new UserDaoMybatis();

    public UserService() {
        this(RESOURCE_ORIGINAL);
    }

    public UserService(String resource) {
        this.resource = resource;
        initSessionFactory();
    }

    private void initSessionFactory() {
        InputStream inputStream = null;
        
        try {
            inputStream = Resources.getResourceAsStream(resource);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch(IOException e) {

        }
    }

    public void addUser(User user) {
        int result = 0;

        logger.info("AddUser Target = " + user);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            userDao.setSqlSession(sqlSession);

            int userCount = userDao.countUser(user.getUserId());

            if(userCount == 0) {
                result = userDao.insertUser(user);
                sqlSession.commit();
                
                logger.debug(user + " : 등록 완료");
            } else {
                logger.error("해당 USER ID(" + user.getUserId() + ")가 이미 존재합니다.");
                throw new DuplicatedKeyException("해당 USER ID(" + user.getUserId() + ")가 이미 존재합니다.");
            }
        } 
    }

    public void updateUser(User user) {
        int result = 0;

        logger.info("Update User Target = " + user);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            userDao.setSqlSession(sqlSession);

            int userCount = userDao.countUser(user.getUserId());

            if(userCount == 1) {
                result = userDao.updateUser(user);
                sqlSession.commit();
                
                logger.debug(user + " : 수정 완료");
            } else {
                logger.error("해당 USER ID(" + user.getUserId() + ")가 등록된 USER가 아닙니다.");
                throw new DuplicatedKeyException("해당 USER ID(" + user.getUserId() + ")가 등록된 USER가 아닙니다.");
            }
        } 
    }

    public void deleteUser(User user) {
        int result = 0;

        logger.info("Delete User Target = " + user);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            userDao.setSqlSession(sqlSession);

            int userCount = userDao.countUser(user.getUserId());

            if(userCount == 1) {
                result = userDao.deleteUser(user);
                sqlSession.commit();
                
                logger.debug(user + " : 삭제 완료");
            } else {
                logger.error("해당 USER ID(" + user.getUserId() + ")가 등록된 USER가 아닙니다.");
                throw new DuplicatedKeyException("해당 USER ID(" + user.getUserId() + ")가 등록된 USER가 아닙니다.");
            }
        } 
    }

    public int countAllUser() {
        int count = 0;

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            userDao.setSqlSession(sqlSession);

            count = userDao.countAll();
        }

        return count;
    }

    public int countUser(String userId) {
        int count = 0;

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            userDao.setSqlSession(sqlSession);

            count = userDao.countUser(userId);
        }

        return count;
    }

    public User getUser(String userId) {
        User user = new User();

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            userDao.setSqlSession(sqlSession);

            user = userDao.getUser(userId);
        }

        return user;
    }
}