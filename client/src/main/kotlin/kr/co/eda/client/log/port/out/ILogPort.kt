package kr.co.eda.client.log.port.out

interface ILogPort {

    fun send(message: String): String
}