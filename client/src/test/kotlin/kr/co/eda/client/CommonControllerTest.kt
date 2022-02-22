package kr.co.eda.client

import com.fasterxml.jackson.databind.ObjectMapper
import kr.co.eda.client.common.dto.response.IResponseResultBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult

@SpringBootTest
@AutoConfigureMockMvc
class CommonControllerTest {

    @Autowired
    protected lateinit var mockMvc: MockMvc

    @Autowired
    protected lateinit var objectMapper: ObjectMapper

    protected fun convertToJsonString(value: Any): String {

        return objectMapper.writeValueAsString(value)
    }

    protected fun <T: IResponseResultBody> parseMvcRespnoseBody(mvcResult: MvcResult, clazz: Class<T>): T {

        val body = this.objectMapper.readValue(mvcResult.response.contentAsString, Map::class.java)["body"]

        return this.objectMapper.convertValue(body, clazz)
    }
}