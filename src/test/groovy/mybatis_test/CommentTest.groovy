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


    @Unroll
    def "Join Test[User Name[#idx] Is User Name Is : #userName]"() {
        given:
            List<Comment> listCom = commentService.selectJoin()

        if( listCom.size() > 2 ) {
            expect : listCom.get(idx).getUser().getUserName().equals(userName);

            where:
            idx | userName
            0 | "1(수정)"
            1 | "1(수정)"
            2 | "1(수정)"
        }
    }

    @Unroll
    def "Select All Test<Comment[#idx] Content is [#content]>"() {
        given:
            commentService.deleteAll()
            
            Comment comment = new Comment()
            comment.setUserId("1")
            comment.setCommentContent("Test")
            commentService.addComment(comment)

            comment = new Comment()
            comment.setUserId("2")
            comment.setCommentContent("Test2")
            commentService.addComment(comment)

            List<Comment> listCom = commentService.selectAllComment()

        expect : listCom.get(idx).getCommentContent().equals(content);

        where:
            idx | content
            0 | "Test"
            1 | "Test2"
        
    }

    def "Comment 제거 테스트"() {
        setup: 
            commentService.deleteAll()

        expect :  (commentService.countAllComment() == 0);
    }

    def "Comment Insert Test"() {
        Comment comment = new Comment()
        comment.setUserId("1")
        comment.setCommentContent("Test")

        given: 
            commentService.deleteAll();
            
        expect : 
            commentService.addComment(comment) == 1
    }

}