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
        return 0;
    }

    public int deleteComment(Comment comment) {
        
        return 0;
    }

    public int countComment(long commentNo) {
        return 0;
    }

    public int countAll_Comment() {
        return this.sqlSession.selectOne("mapper.CommentMapper.countAllComment");
    }

    public Comment getComment(long commentNo) {
        return null;
    }

    public List<Comment> selectAll_Comment() {
        return null;
    }

    public void deleteAllComment() {
        // Sequence 1로 초기화
    }
}