import spock.lang.Specification

import java.util.List
import service.*
import service.exception.*
import model.Comment
import org.junit.experimental.categories.Category
import spock.lang.Unroll 

@Category
class CommentTest extends Specification {
    def commentService = new CommentService()

    def "순번 반환 테스트 오라클"() {
        given : 
            Comment comment = new Comment();
            comment.setUserId("1");
            comment.setCommentContent("TEst");
            
        when : 
            int maxSeq = commentService.addComment(comment);
            int count = commentService.countAllComment()
        
        then : comment.getCommentNo() == count
    }

}