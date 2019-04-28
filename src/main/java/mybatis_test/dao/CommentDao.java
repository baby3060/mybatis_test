package dao;

import model.Comment;

import java.util.*;

public interface CommentDao {
    public int insertComment(Comment comment);
    public int updateComment(Comment comment);
    public int deleteComment(Comment comment);
    public int countComment(String userId);
    public int countAll_Comment();
    public Comment getComment(long commentNo);
    public List<Comment> selectAll_Comment();
    public void deleteAllComment();   
    public List<Comment> selectAllJoin();
}