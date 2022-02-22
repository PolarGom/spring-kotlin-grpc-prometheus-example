package kr.co.eda.client.common.dto.response

import kr.co.eda.client.user.api.dto.response.ResponseUser
import kr.co.eda.client.user.domain.User

data class ResponseList<out T: Any>(
    val list: MutableIterable<T>? = arrayListOf(),
    val totalCount: Int = 0,
    val page: Int = 0): IResponseResultBody
