package com.u.sofia.interceptor

import com.u.sofia.NetworkConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author: Mr.U
 * @date: 2023/3/23
 * @description：
 */
class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        NetworkConfig.getInstance().getHeader().forEach {
            builder.addHeader(it.key, it.value)
        }

        return chain.proceed(builder.build())
    }
}