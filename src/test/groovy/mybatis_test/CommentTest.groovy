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
            List<Comment> listCom = commentService.selectJoin();

        expect : listCom.get(idx).getUser().getUserName().equals(userName);

        where:
        idx | userName
        0 | "1(수정)"
        1 | "1(수정)"
        2 | "1(수정)"
            
    }

}