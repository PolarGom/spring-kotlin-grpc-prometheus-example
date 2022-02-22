package kr.co.eda.client.user.domain

import org.springframework.data.relational.core.mapping.Table

@Table("USER_PHONE")
class UserPhone {

    constructor()

    constructor(id: Long, phoneNumber: String) {

        this.id = id
        this.phoneNumber = phoneNumber
    }

    constructor(userId: Long, id: Long, phoneNumber: String) {

        this.userId = userId
        this.id = id
        this.phoneNumber = phoneNumber
    }

    var userId: Long = 0

    var id: Long = 0

    var phoneNumber: String = ""
}