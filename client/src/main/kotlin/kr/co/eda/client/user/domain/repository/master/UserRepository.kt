package kr.co.eda.client.user.domain.repository.master

import kr.co.eda.client.user.domain.User
import org.apache.ibatis.annotations.Param
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface UserRepository: CrudRepository<User, Long> {

    @Modifying
    @Query(value = "UPDATE USER SET name = :name, description = :description, update_date = :updateDate WHERE id = :id")
    fun update(@Param("id") id: Long, @Param("name") name: String, @Param("description") description: String, @Param("updateDate") updateDate: LocalDateTime): Boolean
}