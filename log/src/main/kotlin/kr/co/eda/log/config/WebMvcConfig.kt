package kr.co.eda.log.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig: WebMvcConfigurer {

    private val MAX_AGE_SECONDS: Long = 3600

    override fun addCorsMappings(registry: CorsRegistry) {

        registry.addMapping("/**")
            .allowedOriginPatterns("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("x-token", "*")
            .allowCredentials(true)
            .maxAge(MAX_AGE_SECONDS)
    }

    @Bean
    fun getRestTemplate(): RestTemplate {

        return RestTemplate()
    }
}