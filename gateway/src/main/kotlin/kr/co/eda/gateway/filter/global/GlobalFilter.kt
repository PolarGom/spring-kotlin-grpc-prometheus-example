package kr.co.eda.gateway.filter.global

import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class GlobalFilter: AbstractGatewayFilterFactory<GlobalConfig>(GlobalConfig::class.java) {

    private val logger = LoggerFactory.getLogger(GlobalFilter::class.java)

    override fun apply(config: GlobalConfig?): GatewayFilter {

        return (GatewayFilter { exchange, chain ->

            val request = exchange.request
            val response = exchange.response

            chain.filter(exchange).then(Mono.fromRunnable {

                logger.info("[Global Filter] Post Response: ${request.uri} -> ${response.statusCode}")
            })
        })
    }

}