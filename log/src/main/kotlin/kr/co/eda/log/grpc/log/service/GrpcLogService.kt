package kr.co.eda.log.grpc.log.service

import io.grpc.stub.StreamObserver
import kr.co.eda.grpc.*
import net.devh.boot.grpc.server.service.GrpcService
import org.slf4j.LoggerFactory

@GrpcService
class GrpcLogService: SimpleGrpc.SimpleImplBase() {

    val logger = LoggerFactory.getLogger(GrpcLogService::class.java)

    override fun sayHello(request: LogRequest?, responseObserver: StreamObserver<LogReply>?) {

        logger.info("[Grpc Log Service] Request: ${request!!.name}")

        val reply = LogReply.newBuilder()
            .setMessage("Hello ===> ${request!!.name}")
            .build()

        responseObserver!!.onNext(reply)
        responseObserver!!.onCompleted()
    }
}