package kr.co.eda.client.common.dto.response

/**
 * 공통 응답 결과
 *
 * @author demo
 * @since 2022-01-21
 * @see {@link IResponseResultBody}
 */
data class ResponseResult<out T: IResponseResultBody> (

    val success: Boolean,
    val errMsg: String,
    val body: T
)