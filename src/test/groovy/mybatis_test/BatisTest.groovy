import spock.lang.Specification

import java.util.List
import service.*
import service.exception.*
import model.User
import org.junit.experimental.categories.Category
import spock.lang.Unroll 

@Category
class BatisTest extends Specification {
    def userService = new UserService()

    def "User Service DeleteAll 기능 테스트"() {
        setup:
        userService.deleteAllUser()

        expect: (userService.countAllUser() == 0)
    }

    def "User Service Add 기능 테스트"() {
        setup:
        userService.deleteAllUser()

        when:
            userService.addUser(new User("1", "1", "1"))
            userService.addUser(new User("2", "2", "2"))
            userService.addUser(new User("3", "3", "3"))
            userService.addUser(new User("4", "4", "4"))
        
        then: (userService.countAllUser() == 4)
    }

    @Unroll
    def "리스트의 값을 기대해본다[List의 Idx : #idx, 기대 Id : #expectId]."() {
        expect: userService.selectAllUser().get(idx).getUserId().equals(expectId)
        
        where:
        idx | expectId
        0 | "1"
        1 | "2"
        2 | "3"
        3 | "4"
    }

    def "User Service의 Update 테스트"() {
        given:
            User user1 = userService.getUser("1")
            user1.setUserName("1(수정)")
            userService.updateUser(user1)

        when: User updateUser = userService.getUser("1")
        then : updateUser.getUserName().equals("1(수정)")
    }

    def "예외 테스트"() {
        given:
            User user1 = userService.getUser("1")

        when : userService.complexInsertAndUpdate(user1)

        then:
        def e = thrown(DuplicatedKeyException.class)
        e.message.equals("해당 USER ID(1)가 이미 존재합니다.")
    }
}