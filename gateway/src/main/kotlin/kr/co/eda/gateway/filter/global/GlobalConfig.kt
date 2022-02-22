package kr.co.eda.gateway.filter.global

data class GlobalConfig(
    val baseMessage: String,
    val preLogger: Boolean,
    val postLogger: Boolean
)