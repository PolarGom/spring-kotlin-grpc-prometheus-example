package kr.co.eda.gateway.filter.clientapi

import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class ClientApiFilter: AbstractGatewayFilterFactory<ClientApiConfig>(ClientApiConfig::class.java) {

    private val logger = LoggerFactory.getLogger(ClientApiFilter::class.java)

    override fun apply(config: ClientApiConfig?): GatewayFilter {

        return (GatewayFilter { exchange, chain ->

            val request = exchange.request
            val response = exchange.response

            chain.filter(exchange).then(Mono.fromRunnable {

            })
        })
    }

}