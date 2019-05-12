package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;

import java.util.*;

import model.User;

public interface UserMapperImpl {


    @Insert("Insert Into TBUSER(user_id, user_pass, user_name) Values (#{userId}, #{userPass}, #{userName})")
    public int insertUser(User user);

    @Update("Update TBUSER Set user_pass = #{userPass}, user_name = #{userName} Where user_id = #{userId} ")
    public int updateUser(User user);

    @Delete("Delete From TBUSER Where user_id = #{userId}")
    public int deleteUser(User user);

    @Delete("Delete From TBUSER")
    public void deleteAll();

    @Select("select count(*) from TBUSER Where user_id = #{userId}")
    public int countUser(String userId);

    @Select("Select Count(*) From TBUSER")
    public int countAllUser();

    @Select("select * from TBUSER Where user_id = #{userId}")
    @Results(id = "userResult", value = {
        @Result(property = "userId", column = "user_id", id = true),
        @Result(property = "userPass", column = "user_pass"),
        @Result(property = "userName", column = "user_name")
      })
    public User getUser(String userId);


    @Select("Select * From TBUSER Order By user_id")
    @ResultMap("userResult")
    public List<User> selectAll();
}