/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package mybatis_test;

import java.util.List;

import dao.*;

import model.*;

import service.*;
import service.exception.*;

// XML 없이 SqlSessionFactory 생성 
        
/*
    DataSource dataSource = 데이터 소스 따로 생성
    TransactionFactory transactionFactory = new JdbcTransactionFactory();
    Environment environment = new Environment("development", transactionFactory, dataSource);
    Configuration configuration = new Configuration(environment);
    configuration.addMapper(User.class);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
*/

public class App {
    
    public static void main(String[] args) {
        UserService service = new UserService();

        int count = service.countAllUser();

        System.out.println("user Count is " + count);

        if( count > 0 ) {
            service.deleteAllUser();
        }

        List<User> result = service.selectAllUser();

        System.out.println("selectAllUser Result Is " + result);

        count = service.countAllUser();

        System.out.println("user Count is " + count);

        User user1 = service.getUser("1");

        System.out.println("Get User(1) : " + user1);        

        user1.setUserName("1(수정)");

        service.updateUser(user1);

        user1 = service.getUser("1");

        System.out.println("Get User(1) : " + user1);        


        System.out.println("=================================");

        service.deleteAllUser();
        
        service.complexInsertAndUpdate(new User("1", "1", "1"));
    }
}
