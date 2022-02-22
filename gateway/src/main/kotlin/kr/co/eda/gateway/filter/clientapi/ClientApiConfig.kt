package kr.co.eda.gateway.filter.clientapi

data class ClientApiConfig(
    val baseMessage: String,
    val preLogger: Boolean,
    val postLogger: Boolean
)