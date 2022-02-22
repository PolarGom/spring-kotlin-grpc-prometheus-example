package kr.co.eda.client.log.adapter.out

import io.grpc.StatusRuntimeException
import kr.co.eda.client.log.exception.LogException
import kr.co.eda.client.log.port.out.ILogPort
import kr.co.eda.grpc.*
import net.devh.boot.grpc.client.inject.GrpcClient
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class LogAdapter: ILogPort {

    private val logger = LoggerFactory.getLogger(LogAdapter::class.java)

    @GrpcClient("log")
    private lateinit var stub: LogGrpc.LogBlockingStub

    override fun send(message: String): String {

        try {

            var response: LogReply = this.stub.send(LogRequest.newBuilder().setName(message).build())

            return response.message
        } catch ( e: StatusRuntimeException ) {

            val message = "로그 전송 중 오류가 발생하였습니다.[Code: ${e.status.code.name}]"

            logger.error("[Grpc 오류] $message", e)
            throw LogException("$message", e)
        }
    }
}