package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.SelectKey;

import java.util.*;

import model.Comment;

public interface CommentMapperImpl {
    @Select("Select comment_no, user_id, comment_content " +
                " , reg_date , Row_Number() Over(Order By comment_no) As comment_seq " +
            "From TBCOMMENT")
    @Results(id="simpleMap", value={
        @Result(property="commentNo", column="comment_no", id = true),
        @Result(property="userId", column="user_id"),
        @Result(property="commentContent", column="comment_content"),
        @Result(property="regDate", column="reg_date"),
        @Result(property="commentSeq", column="comment_seq")
    })
    public List<Comment> selectCommentAll();

    @Select("Select Count(*) As cnt From TBCOMMENT")
    public int countAll();

    @Select("Select Count(*) As cnt From TBCOMMENT Where userId = #{userId}")
    public int countComment(String userId);

    @Results(id="commentJoinMap", value={
        @Result(property="commentNo", column="comment_no", id = true),
        @Result(property="userId", column="user_id"
              , one = @One(select="getUserName")),
        @Result(property="commentContent", column="comment_content"),
        @Result(property="regDate", column="reg_date")
    })
    @Select("Select a.comment_no, a.user_id, a.comment_content, a.reg_date " +
                " , b.user_name " +
                " , Row_Number() Over(Order By a.comment_no) As comment_seq " +
            " From TBCOMMENT a " +
            " Inner Join TBUSER b On (b.user_id = a.user_id) " +
            " Where a.comment_no = #{commentNo}")
    public Comment getComment(long commentNo);

    @Select("Select user_name From TBUSER Where user_id = #{userId} ")
    public String getUserName(String userId);

    
    @Select("Select a.comment_no, a.user_id, a.comment_content, a.reg_date " +
                " , b.user_name " +
                " , Row_Number() Over(Order By a.comment_no) As comment_seq " +
            " From TBCOMMENT a " +
            " Inner Join TBUSER b On (b.user_id = a.user_id)")
    @ResultMap("commentJoinMap")
    public List<Comment> selectAllJoin();

    @Update("Update TBCOMMENT " +
            " Set comment_content = #{commentContent} " +
            " Where comment_no = #{commentNo}")
    public int updateComment(Comment comment);

    @Delete("Delete From TBCOMMENT Where comment_no = #{commentNo}")
    public int deleteComment(Comment comment);

    @Delete("Delete From TBCOMMENT")
    public void deleteAllComment();

    @Insert("Insert Into TBCOMMENT (comment_no, user_id, comment_content, reg_date) Values (TBCOMMENT_SEQ.NEXTVAL, #{userId}, #{commentContent}, SYSDATE)")
    @SelectKey(statement="Select TBCOMMENT_SEQ.CURRVAL FROM DUAL", keyProperty="commentNo", before=false, resultType=long.class)
    public int insertComment(Comment comment);

    @Update("DROP SEQUENCE TBCOMMENT_SEQ")
    public void dropSequence();

    @Update("CREATE SEQUENCE TBCOMMENT_SEQ " +
            " START WITH 1 " +
            " MAXVALUE 99999999 " +
            " MINVALUE 0 " +
            " NOCYCLE " +
            " CACHE 20 " +
            " NOORDER")
    public void createSequence();            
}