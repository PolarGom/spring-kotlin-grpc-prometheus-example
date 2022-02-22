package kr.co.eda.client.user.api.dto.request

data class RequestUpdateUser(
    val id: Long,
    val name: String,
    val description: String,
)
