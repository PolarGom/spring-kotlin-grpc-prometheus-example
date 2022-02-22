package kr.co.eda.client.config

import kr.co.eda.client.common.exception.Common400Exception
import kr.co.eda.client.common.dto.response.ResponseResult
import kr.co.eda.client.common.dto.response.ResponseUnit
import kr.co.eda.client.common.exception.Common500Exception
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalControllerAdvice {

    @ExceptionHandler(value = [Common400Exception::class])
    fun commonExceptionHandler(e: Common400Exception): ResponseEntity<ResponseResult<ResponseUnit>> {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseResult(false, e.message!!, ResponseUnit()))
    }

    @ExceptionHandler(value = [Common500Exception::class])
    fun commonExceptionHandler(e: Common500Exception): ResponseEntity<ResponseResult<ResponseUnit>> {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseResult(false, e.message!!, ResponseUnit()))
    }
}