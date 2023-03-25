package com.u.sofia.repository

import com.u.sofia.HttpResult

/**
 * @author: Mr.U
 * @date: 2023/3/22
 * @description：搞这个是因为后台返回的数据结构不全都是BaseModel
 *
 */
abstract class BaseRepository {

    suspend fun <T : Any> call(request: suspend () -> Any): HttpResult<T> {
        return try {
            executeResponse(request())
        } catch (e: Exception) {
            HttpResult.Error(e)
        }
    }

    abstract fun <T : Any> executeResponse(response: Any): HttpResult<T>


}