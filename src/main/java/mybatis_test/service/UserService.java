package service;

import java.io.*;

import dao.*;

import model.User;
import service.exception.DuplicatedKeyException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import service.exception.*;

/**
 * 단순하게 바로 Class로 만듦(원래는 Interface로 하는게 좋음)
 */
public class UserService {
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

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            userDao.setSqlSession(sqlSession);

            int userCount = userDao.countUser(user.getUserId());

            if(userCount == 0) {
                result = userDao.insertUser(user);
                sqlSession.commit();
            } else {
                throw new DuplicatedKeyException("해당 USER ID(" + user.getUserId() + ")가 이미 존재합니다.");
            }
        } 
    }
}