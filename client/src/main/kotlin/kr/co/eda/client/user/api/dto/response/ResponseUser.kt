package kr.co.eda.client.user.api.dto.response

import kr.co.eda.client.common.dto.response.IResponseResultBody
import kr.co.eda.client.user.domain.User
import java.time.LocalDateTime

data class ResponseUser(
    val id: Long?,
    val name: String,
    val description: String,
    val createDate: LocalDateTime,
    val updateDate: LocalDateTime,
    val userPhones: MutableSet<ResponseUserPhone>
): IResponseResultBody {

    companion object {

        fun toResponseList(userList: MutableIterable<User>): MutableIterable<ResponseUser> {

            var resultList = mutableListOf<ResponseUser>()

            userList.forEach {
                resultList.add(ResponseUser(it.id, it.name, it.description, it.createDate!!, it.updateDate!!, ResponseUserPhone.toResponseList(it.userPhones)))
            }

            return resultList
        }
    }
}
