package kr.co.eda.client.user.exception

import kr.co.eda.client.common.exception.Common500Exception

class UserNotFoundException: Common500Exception("사용자를 찾을 수 없습니다.", NullPointerException()) {
}