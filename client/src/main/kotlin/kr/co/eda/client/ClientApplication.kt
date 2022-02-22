package kr.co.eda.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing

@SpringBootApplication
@EnableJdbcAuditing
class ClientApplication

fun main(args: Array<String>) {
	runApplication<ClientApplication>(*args)
}
