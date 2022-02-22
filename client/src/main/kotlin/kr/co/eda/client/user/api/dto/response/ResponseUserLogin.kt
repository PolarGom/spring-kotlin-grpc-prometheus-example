package kr.co.eda.client.user.api.dto.response

import kr.co.eda.client.common.dto.response.IResponseResultBody

data class ResponseUserLogin(
    val token: String
): IResponseResultBody