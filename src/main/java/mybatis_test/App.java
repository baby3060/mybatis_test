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
        CommentService commentService = new CommentService();

        Comment comment = new Comment();
        comment.setUserId("1");
        comment.setCommentContent("TEst");

        commentService.addComment(comment);

        System.out.println(comment);
    }
}
