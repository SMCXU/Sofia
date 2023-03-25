package com.u.sofia

/**
 * @author: Mr.U
 * @date: 2023/3/22
 * @description：
 */
sealed class HttpResult<out T : Any> {

    //成功
    data class Success<out T : Any>(val data: T) : HttpResult<T>()

    //后台主动报出的异常
    data class Failure(val reason: String) : HttpResult<Nothing>()

    //网络和服务器造成的404，502，或者DNS请求失败等错误状态
    data class Error(val e: Exception) : HttpResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Failure -> "Failure[reason=$reason]"
            is Error -> "Error[exception=$e]"
        }
    }


}