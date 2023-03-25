package com.u.sofia.interceptor

import android.content.Context
import com.u.sofia.NetworkConfig
import com.u.sofia.util.NetworkUtils
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author: Mr.U
 * @date: 2023/3/25
 * @description：处理缓存，在这里加缓存策略吧
 */
class CacheInterceptor(val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (!NetworkUtils.isNetworkConnected(context)) {
            request = request.newBuilder()
                .header(
                    "Cache-Control",
                    "public, only-if-cached, max-stale=${
                        NetworkConfig.getInstance().getCacheDuration()
                    }"
                ) //设置本地缓存时间为1周
                .build()

        }
        return chain.proceed(request)
    }

}