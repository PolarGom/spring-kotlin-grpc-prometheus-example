package kr.co.eda.client.config.database

import com.zaxxer.hikari.HikariDataSource
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.TransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableJdbcRepositories(jdbcOperationsRef = "masterJdbcOperations",
    basePackages = ["kr.co.eda.client.**.repository.master"],
    transactionManagerRef = "masterTranscationManager")
@EnableTransactionManagement
class MasterDataSourceConfig: AbstractJdbcConfiguration() {

    @Bean(name = ["masterDataSource"])
    @Qualifier("masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari.master")
    fun masterDataSource(): DataSource {

        return DataSourceBuilder.create().type(HikariDataSource::class.java).build()
    }

    @Bean
    fun masterJdbcOperations(@Qualifier("masterDataSource") masterDataSource: DataSource): NamedParameterJdbcOperations {

        return NamedParameterJdbcTemplate(masterDataSource)
    }

    @Bean(name = ["masterTranscationManager"])
    @Primary
    fun masterTransactionManager(@Qualifier("masterDataSource") masterDataSource: DataSource): TransactionManager {

        return DataSourceTransactionManager(masterDataSource)
    }
}