package dao;

import model.User;
import connection.*;

import java.util.*;

import java.sql.*;


public class UserDaoJdbc implements UserDao {

    public int insertUser(User user) {
        Connection conn = ConnectionMaker.getConnection();
        PreparedStatement pstmt = null;

        int result = 0;

        String sql = "Insert Into TBUSER(user_id, user_pass, user_name) Values (?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserPass());
            pstmt.setString(3, user.getUserName());

            result = pstmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if( pstmt != null ) {
                try { 
                    pstmt.close();
                } catch(Exception e){}
            }
            if( conn != null ) {
                try { 
                    conn.close();
                } catch(Exception e){}
            }
        }
        
        return result;
    }

    public int updateUser(User user) {
        Connection conn = ConnectionMaker.getConnection();
        PreparedStatement pstmt = null;

        int result = 0;

        String sql = "Update TBUSER set user_pass = ?, user_name = ? Where user_id = ?";

        try {
            pstmt = conn.prepareStatement(sql);

            
            pstmt.setString(1, user.getUserPass());
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3, user.getUserId());

            result = pstmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if( pstmt != null ) {
                try { 
                    pstmt.close();
                } catch(Exception e){}
            }
            if( conn != null ) {
                try { 
                    conn.close();
                } catch(Exception e){}
            }
        }
        
        return result;
    }

    public int deleteUser(User user) {
        return this.deleteUser(user.getUserId());
    }

    private int deleteUser(String userId) {
        Connection conn = ConnectionMaker.getConnection();
        PreparedStatement pstmt = null;

        int result = 0;

        String sql = "Delete From TBUSER Where user_id = ?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, userId);

            result = pstmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if( pstmt != null ) {
                try { 
                    pstmt.close();
                } catch(Exception e){}
            }
            if( conn != null ) {
                try { 
                    conn.close();
                } catch(Exception e){}
            }
        }
        
        return result;
    }

    public int countUser(String userId) {
        Connection conn = ConnectionMaker.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int count = 0;

        String sql = "Select Count(*) As cnt From TBUSER Where user_id = ?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            if( rs.next() ) {
                count = rs.getInt("cnt");
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if( rs != null ) {
                try { 
                    rs.close();
                } catch(Exception e){}
            }
            if( pstmt != null ) {
                try { 
                    pstmt.close();
                } catch(Exception e){}
            }
            if( conn != null ) {
                try { 
                    conn.close();
                } catch(Exception e){}
            }
        }
        
        return count;
    }

    public int countAll() {
        Connection conn = ConnectionMaker.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int count = 0;

        String sql = "Select Count(*) As cnt From TBUSER";

        try {
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            if( rs.next() ) {
                count = rs.getInt("cnt");
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if( rs != null ) {
                try { 
                    rs.close();
                } catch(Exception e){}
            }
            if( pstmt != null ) {
                try { 
                    pstmt.close();
                } catch(Exception e){}
            }
            if( conn != null ) {
                try { 
                    conn.close();
                } catch(Exception e){}
            }
        }
        
        return count;
    }

    public User getUser(String userId) {

        Connection conn = ConnectionMaker.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        User user = new User();

        String sql = "Select user_id, user_pass, user_name As cnt From TBUSER Where user_id = ?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            if( rs.next() ) {
                user = new User();

                user.setUserId(rs.getString("user_id"));
                user.setUserPass(rs.getString("user_pass"));
                user.setUserName(rs.getString("user_name"));
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if( rs != null ) {
                try { 
                    rs.close();
                } catch(Exception e){}
            }
            if( pstmt != null ) {
                try { 
                    pstmt.close();
                } catch(Exception e){}
            }
            if( conn != null ) {
                try { 
                    conn.close();
                } catch(Exception e){}
            }
        }
        
        return user;
    }

    public List<User> selectAll() {
        Connection conn = ConnectionMaker.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<User>();
        User user = new User();

        String sql = "Select user_id, user_pass, user_name As cnt From TBUSER Order By user_id";

        try {
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while( rs.next() ) {
                user = new User();

                user.setUserId(rs.getString("user_id"));
                user.setUserPass(rs.getString("user_pass"));
                user.setUserName(rs.getString("user_name"));

                list.add(user);
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if( rs != null ) {
                try { 
                    rs.close();
                } catch(Exception e){}
            }
            if( pstmt != null ) {
                try { 
                    pstmt.close();
                } catch(Exception e){}
            }
            if( conn != null ) {
                try { 
                    conn.close();
                } catch(Exception e){}
            }
        }
        
        return list;
    }

    public void deleteAll() {
        Connection conn = ConnectionMaker.getConnection();
        PreparedStatement pstmt = null;

        String sql = "Delete From TBUSER";

        try {

            pstmt = conn.prepareStatement(sql);

            pstmt.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            
            if( pstmt != null ) {
                try { 
                    pstmt.close();
                } catch(Exception e){}
            }
            if( conn != null ) {
                try { 
                    conn.close();
                } catch(Exception e){}
            }
        }
    }

}