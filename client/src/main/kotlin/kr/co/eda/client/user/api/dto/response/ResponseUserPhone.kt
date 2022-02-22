package kr.co.eda.client.user.api.dto.response

import kr.co.eda.client.common.dto.response.IResponseResultBody
import kr.co.eda.client.user.domain.User
import kr.co.eda.client.user.domain.UserPhone
import java.time.LocalDateTime

data class ResponseUserPhone(
    val userId: Long?,
    val id: Long?,
    val phoneNumber: String
): IResponseResultBody {

    companion object {

        fun toResponseList(userList: MutableSet<UserPhone>): MutableSet<ResponseUserPhone> {

            var resultList = mutableSetOf<ResponseUserPhone>()

            userList.forEach {
                resultList.add(ResponseUserPhone(it.userId, it.id, it.phoneNumber))
            }

            return resultList
        }
    }
}
