package kr.co.eda.client.user.application

import kr.co.eda.client.common.exception.Common400Exception
import kr.co.eda.client.common.dto.response.ResponseList
import kr.co.eda.client.common.dto.response.ResponseResult
import kr.co.eda.client.common.dto.response.ResponseUnit
import kr.co.eda.client.log.port.out.ILogPort
import kr.co.eda.client.user.api.dto.request.RequestAddUser
import kr.co.eda.client.user.api.dto.request.RequestUpdateUser
import kr.co.eda.client.user.api.dto.request.RequestUserLogin
import kr.co.eda.client.user.api.dto.response.ResponseUser
import kr.co.eda.client.user.api.dto.response.ResponseUserLogin
import kr.co.eda.client.user.domain.User
import kr.co.eda.client.user.domain.UserPhone
import kr.co.eda.client.user.domain.repository.master.UserRepository
import kr.co.eda.client.user.exception.UserNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class UserServiceImpl: IUserService {

    private val logger = LoggerFactory.getLogger(UserServiceImpl::class.java)

    private val userRepository: UserRepository

    private val logPort: ILogPort

    constructor(userRepository: UserRepository, logPort: ILogPort) {

        this.userRepository = userRepository
        this.logPort = logPort
    }

    override fun findAllUser(): ResponseResult<ResponseList<ResponseUser>> {

        var userList = userRepository.findAll()

        return ResponseResult(true, "", ResponseList(ResponseUser.toResponseList(userList), 0, 0))
    }

    override fun login(requestUserLogin: RequestUserLogin): ResponseResult<ResponseUserLogin> {

        logger.info("GRPC 전송 시작")
        val message = logPort.send(requestUserLogin.id)
        logger.info("GRPC 응답 정보 ::: $message")
        logger.info("GRPC 전송 종료")

        return ResponseResult(true, "", ResponseUserLogin("TODO-TOKEN"))
    }

    @Transactional(value = "masterTranscationManager", rollbackFor = [Common400Exception::class])
    override fun addUser(requestAddUser: RequestAddUser): ResponseResult<ResponseUnit> {

        val user = User(name = requestAddUser.name, description = requestAddUser.description)
        user.userPhones.add(UserPhone(1, "01033331111"))
        user.userPhones.add(UserPhone(2, "01033331112"))
        user.userPhones.add(UserPhone(3, "01033331113"))

        userRepository.save(user)

        logger.info("[사용자 등록] 결과 정보: $user")

        return ResponseResult(true, "", ResponseUnit())
    }

    @Transactional(value = "masterTranscationManager", rollbackFor = [Common400Exception::class])
    override fun updateUser(requestUpdateUser: RequestUpdateUser): ResponseResult<ResponseUnit> {

        val result = userRepository.update(requestUpdateUser.id, requestUpdateUser.name, requestUpdateUser.description, LocalDateTime.now())

        if ( !result ) {

            throw UserNotFoundException()
        }

        logger.info("[사용자 수정] 결과 정보: $requestUpdateUser")

        return ResponseResult(true, "", ResponseUnit())
    }

    override fun deleteUser(id: Long): ResponseResult<ResponseUnit> {

        userRepository.deleteById(id)

        return ResponseResult(true, "", ResponseUnit())
    }
}