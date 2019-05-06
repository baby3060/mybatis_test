package dao;

import model.Comment;

import java.util.*;

public interface CommentDao {
    int insertComment(Comment comment);
    int updateComment(Comment comment);
    int deleteComment(Comment comment);
    int countComment(String userId);
    int countAll_Comment();
    Comment getComment(long commentNo);
    List<Comment> selectAll_Comment();
    void deleteAllComment();   
    List<Comment> selectAllJoin();
    void dropSequence();
    void createSequence();
}