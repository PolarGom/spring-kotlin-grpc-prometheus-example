package kr.co.eda.client.user.api

import kr.co.eda.client.common.dto.response.ResponseList
import kr.co.eda.client.common.dto.response.ResponseResult
import kr.co.eda.client.common.dto.response.ResponseUnit
import kr.co.eda.client.user.api.dto.request.RequestAddUser
import kr.co.eda.client.user.api.dto.request.RequestUpdateUser
import kr.co.eda.client.user.api.dto.request.RequestUserLogin
import kr.co.eda.client.user.api.dto.response.ResponseUser
import kr.co.eda.client.user.api.dto.response.ResponseUserLogin
import kr.co.eda.client.user.application.IUserService
import kr.co.eda.client.user.domain.UserPhone
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController {

    private val logger = LoggerFactory.getLogger(UserController::class.java)

    private val userServiceImpl: IUserService

    constructor(userService: IUserService) {

        this.userServiceImpl = userService
    }

    @PostMapping(value = ["/login"])
    fun getLogin(@RequestBody requestUserLogin: RequestUserLogin): ResponseEntity<ResponseResult<ResponseUserLogin>> {

        logger.info("[로그인] 요청 정보: $requestUserLogin")

        return ResponseEntity.ok(userServiceImpl.login(requestUserLogin))
    }

    @GetMapping(value = ["/users"])
    fun findAllUser(): ResponseEntity<ResponseResult<ResponseList<ResponseUser>>> {

        logger.info("[사용자 목록] 요청")

        return ResponseEntity.ok(userServiceImpl.findAllUser())
    }

    @PostMapping(value = ["/users"])
    fun addUser(@RequestBody requestAddUser: RequestAddUser): ResponseEntity<ResponseResult<ResponseUnit>> {

        logger.info("[사용자 등록] 요청 정보: $requestAddUser")

        return ResponseEntity.ok(userServiceImpl.addUser(requestAddUser))
    }

    @PutMapping(value = ["/users"])
    fun updateUser(@RequestBody requestUpdateUser: RequestUpdateUser): ResponseEntity<ResponseResult<ResponseUnit>> {

        logger.info("[사용자 수정] 요청 정보: $requestUpdateUser")

        return ResponseEntity.ok(userServiceImpl.updateUser(requestUpdateUser))
    }

    @DeleteMapping(value = ["/users/{id}"])
    fun deleteUser(@PathVariable id: Long): ResponseEntity<ResponseResult<ResponseUnit>> {

        logger.info("[사용자 삭제] 요청 정보: $id")

        return ResponseEntity.ok(userServiceImpl.deleteUser(id))
    }
}