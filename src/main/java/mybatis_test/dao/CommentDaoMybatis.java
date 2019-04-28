package dao;

import model.Comment;
import java.util.*;
import org.apache.ibatis.session.SqlSession;

public class CommentDaoMybatis implements CommentDao {

    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insertComment(Comment comment) {
        // 가장 마지막에 생성된 자동 Key 반환(NextVal)
        return (int)this.sqlSession.insert("mapper.CommentMapper.addComment", comment);
    }

    public int updateComment(Comment comment) {
        return (int)this.sqlSession.update("mapper.CommentMapper.updateComment", comment);
    }

    public int deleteComment(Comment comment) {
        return (int)this.sqlSession.delete("mapper.CommentMapper.deleteComment", comment);
    }

    public int countAll_Comment() {
        return this.sqlSession.selectOne("mapper.CommentMapper.countAllComment");
    }

    public int countComment(String userId) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("userId", userId);

        return this.sqlSession.selectOne("mapper.CommentMapper.countComment", param);
    }

    public Comment getComment(long commentNo) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("commentNo", commentNo);

        return this.sqlSession.selectOne("mapper.CommentMapper.getComment", param);
    }

    public List<Comment> selectAll_Comment() {
        return this.sqlSession.selectList("mapper.CommentMapper.selectCommentAll");
    }

    public void deleteAllComment() {
        // Sequence 1로 초기화
    }

    public List<Comment> selectAllJoin() {
        return this.sqlSession.selectList("mapper.CommentMapper.joinCommentUser");
    }
}