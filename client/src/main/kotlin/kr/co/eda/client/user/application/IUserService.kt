package kr.co.eda.client.user.application

import kr.co.eda.client.common.dto.response.ResponseList
import kr.co.eda.client.common.dto.response.ResponseResult
import kr.co.eda.client.common.dto.response.ResponseUnit
import kr.co.eda.client.user.api.dto.request.RequestAddUser
import kr.co.eda.client.user.api.dto.request.RequestUpdateUser
import kr.co.eda.client.user.api.dto.request.RequestUserLogin
import kr.co.eda.client.user.api.dto.response.ResponseUser
import kr.co.eda.client.user.api.dto.response.ResponseUserLogin

interface IUserService {

    fun findAllUser(): ResponseResult<ResponseList<ResponseUser>>

    fun login(requestUserLogin: RequestUserLogin): ResponseResult<ResponseUserLogin>

    fun addUser(requestAddUser: RequestAddUser): ResponseResult<ResponseUnit>

    fun updateUser(requestUpdateUser: RequestUpdateUser): ResponseResult<ResponseUnit>

    fun deleteUser(id: Long): ResponseResult<ResponseUnit>
}