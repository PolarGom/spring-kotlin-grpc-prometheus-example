package kr.co.eda.client.user.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import java.time.LocalDateTime

@Table("USER")
class User {

    constructor()

    constructor(name: String, description: String) {
        this.name = name
        this.description = description
    }

    @Id
    var id: Long? = null

    lateinit var name: String

    lateinit var description: String

    @CreatedDate
    @Column(value = "create_date")
    var createDate: LocalDateTime? = null

    @LastModifiedDate
    @Column(value = "update_date")
    var updateDate: LocalDateTime? = null

    @MappedCollection(idColumn = "user_id", keyColumn = "id")
    var userPhones: MutableSet<UserPhone> = mutableSetOf()

    fun update(name: String, description: String) {

        this.name = name
        this.description = description
    }

    override fun toString(): String {
        return "User(id=$id, name='$name', description='$description', createDate=$createDate, updateDate=$updateDate)"
    }
}
