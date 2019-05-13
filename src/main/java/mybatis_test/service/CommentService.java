package service;

import java.io.*;
import java.util.*;

import dao.*;

import model.Comment;
import service.exception.DuplicatedKeyException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import service.exception.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 단순하게 바로 Class로 만듦(원래는 Interface로 하는게 좋음)
 */
public class CommentService {
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    private final static String RESOURCE_ORIGINAL = "mybatis-config.xml";
    private String resource = RESOURCE_ORIGINAL;

    private SqlSessionFactory sqlSessionFactory;

    private CommentDaoMybatis commentDao = new CommentDaoMybatis();

    public CommentService() {
        this(RESOURCE_ORIGINAL);
    }

    public CommentService(String resource) {
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

    public int addComment(Comment comment) {
        int result = 0;

        logger.info("addComment Target = " + comment);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            commentDao.setSqlSession(sqlSession);
            
            result = commentDao.insertComment(comment);
            sqlSession.commit();
            
            logger.debug(result + "번 게시물 : " + comment + " 등록 완료");
        } 

        return result;
    }

    public int countAllComment() {
        int count = 0;

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            commentDao.setSqlSession(sqlSession);

            count = commentDao.countAll_Comment();
        }

        return count;
    }

    public List<Comment> selectAllComment() {
        List<Comment> result = new ArrayList<Comment>();

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            commentDao.setSqlSession(sqlSession);

            result = commentDao.selectAll_Comment();
        }

        return result;
    }

    public List<Comment> selectJoin() {
        List<Comment> result = new ArrayList<Comment>();

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            commentDao.setSqlSession(sqlSession);

            result = commentDao.selectAllJoin();
        }

        return result;
    }

    public void deleteAll() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            commentDao.setSqlSession(sqlSession);

            commentDao.deleteAllComment();

            commentDao.dropSequence();

            commentDao.createSequence();
        }
    }

}