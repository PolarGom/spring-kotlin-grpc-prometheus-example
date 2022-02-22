package kr.co.eda.client.user.api

import kr.co.eda.client.CommonControllerTest
import kr.co.eda.client.user.api.dto.request.RequestAddUser
import kr.co.eda.client.user.api.dto.request.RequestUpdateUser
import kr.co.eda.client.user.api.dto.request.RequestUserLogin
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import kotlin.random.Random

class UserControllerTest: CommonControllerTest() {

    @Test
    @Order(1)
    @DisplayName("로그인 테스트")
    fun testGetLogin() {

        val id = "user1"
        val pw = "1234"

        val content = this.convertToJsonString(RequestUserLogin(id, pw))

        val mvcResult = this.mockMvc.perform(
            MockMvcRequestBuilders.post("/login")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()
    }

    @Test
    @Order(2)
    @DisplayName("사용자 등록")
    fun testAddUser() {

        val name = "홍길동"
        val description = "설명 ${System.currentTimeMillis()}"

        val content = this.convertToJsonString(RequestAddUser(name, description))

        val mvcResult = this.mockMvc.perform(
            MockMvcRequestBuilders.post("/users")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()
    }

    @Test
    @Order(3)
    @DisplayName("사용자 수정")
    fun testUpdateUser() {

        // 애그리거트 루트 수정시 하위 애그리거트를 모두 삭제 후 다시 Insert 한다.
        // 그래서 하위 애그리거트에 데이터베이스의 Auto Increment 가 있을 경우 값이 변경되는 현상이 발생 된다. 주의 해야 한다.
        val id: Long = 99
        val name = "홍길동 ${Random(10).nextInt()}"
        val description = "설명 ${System.currentTimeMillis()}"

        val content = this.convertToJsonString(RequestUpdateUser(id, name, description))

        val mvcResult = this.mockMvc.perform(
            MockMvcRequestBuilders.put("/users")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()
    }

    @Test
    @Order(4)
    @DisplayName("사용자 목록 조회")
    fun testFindAllUser() {

        // 애그리거트 루트가 조회되면 그 하위 애그리거트가 모두 조회됨(N+1 문제 발생)
        // N+1 회피하려면 연관관계를 끊거나 크게 성능 하락이 없지 않는 이상 그냥 사용해도 될것으로 보임
        val mvcResult = this.mockMvc.perform(
            MockMvcRequestBuilders.get("/users")
        ).andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()
    }

    @Test
    @Order(5)
    @DisplayName("사용자 삭제")
    fun testDeleteUser() {

        // 애그리거트 루트가 사라지면 하위 애그리거트까지 모두 사라짐(HARD DELETE)
        // SOFT DELETE: 실제 값은 데이터베이스에 존재하며 상태 값만 변경 한다.(예. state_delete 컬럼을 두고 해당 컬럼 값만 변경)
        // SOFT DELETE 예시: https://github.com/mhyeon-lee/spring-data-sample-codes/tree/master/spring-data-jdbc-sample/src/main/java/spring/data/jdbc/account
        val id: Long = 2

        val mvcResult = this.mockMvc.perform(
            MockMvcRequestBuilders.delete("/users/$id")
        ).andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()
    }
}