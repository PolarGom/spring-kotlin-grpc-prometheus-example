package kr.co.eda.client.log.exception

import kr.co.eda.client.common.exception.Common500Exception

class LogException(message: String, cause: Throwable): Common500Exception(message, cause) {
}