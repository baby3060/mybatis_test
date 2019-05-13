package dao;

import model.Comment;
import mapper.CommentMapperImpl;
import java.util.*;
import org.apache.ibatis.session.SqlSession;

public class CommentDaoMybatis implements CommentDao {

    private SqlSession sqlSession;

    private CommentMapperImpl commentMapper;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        this.commentMapper = sqlSession.getMapper(CommentMapperImpl.class);
    }

    public int insertComment(Comment comment) {
        // 가장 마지막에 생성된 자동 Key 반환(NextVal)
        return this.commentMapper.insertComment(comment);
    }

    public int updateComment(Comment comment) {
        // return (int)this.sqlSession.update("mapper.CommentMapper.updateComment", comment);
        return this.commentMapper.updateComment(comment);
    }

    public int deleteComment(Comment comment) {
        // return (int)this.sqlSession.delete("mapper.CommentMapper.deleteComment", comment);
        return this.commentMapper.deleteComment(comment);
    }

    public int countAll_Comment() {
        return this.commentMapper.countAll();
        // return this.sqlSession.selectOne("mapper.CommentMapper.countAllComment");
    }

    public int countComment(String userId) {
        /*
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("userId", userId);

        return this.sqlSession.selectOne("mapper.CommentMapper.countComment", param);
        */
        return this.commentMapper.countComment(userId);
    }

    public Comment getComment(long commentNo) {
        /*
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("commentNo", commentNo);

        return this.sqlSession.selectOne("mapper.CommentMapper.getComment", param);
        */
        return this.commentMapper.getComment(commentNo);
    }

    public List<Comment> selectAll_Comment() {
        return this.commentMapper.selectCommentAll();
        // return this.sqlSession.selectList("mapper.CommentMapper.selectCommentAll");
    }

    public void deleteAllComment() {
        // this.sqlSession.delete("mapper.CommentMapper.deleteAll");
        this.commentMapper.deleteAllComment();
    }

    public void dropSequence() {
        // this.sqlSession.update("mapper.CommentMapper.deleteSeq");
        this.commentMapper.dropSequence();
    }

    public void createSequence() {
        // this.sqlSession.update("mapper.CommentMapper.createSeq");
        this.commentMapper.createSequence();
    }

    public List<Comment> selectAllJoin() {
        // return this.sqlSession.selectList("mapper.CommentMapper.joinCommentUser");
        return this.commentMapper.selectAllJoin();
    }
}