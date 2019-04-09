package connection;

import java.sql.*;

public class ConnectionMaker {
    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "mybatis", "mybatisdb");
        } catch(Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}