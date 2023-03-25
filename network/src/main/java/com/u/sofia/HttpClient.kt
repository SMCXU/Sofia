package com.u.sofia


import android.util.LruCache
import com.u.sofia.interceptor.CacheInterceptor

import com.u.sofia.interceptor.HeaderInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit

/**
 * @author: Mr.U
 * @date: 2023/3/22
 * @description：
 */
object HttpClient {
    private val retrofitsCache = LruCache<String, Retrofit>(8)
    private val apiServiceCache = LruCache<String, Any>(8)
    private val cache = Cache(Sofia.instance.getContext().cacheDir, NetworkConfig.getInstance().getCacheSize())

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (NetworkConfig.getInstance().isDebug()) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.BASIC
                }
            })
            .addInterceptor(HeaderInterceptor())
            .addInterceptor(CacheInterceptor(Sofia.instance.getContext()))
            //证书稍后再说,
//            .sslSocketFactory(CertsManager.createSSLSocketFactory(),)
                //cookie稍等
            .connectTimeout(NetworkConfig.getInstance().getConnectTime(), TimeUnit.MILLISECONDS)
            .readTimeout(NetworkConfig.getInstance().getReadTime(), TimeUnit.MILLISECONDS)
            .writeTimeout(NetworkConfig.getInstance().getWriteTime(), TimeUnit.MILLISECONDS)
            .build()
    }

    private fun createRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    //AF和DQD多baseUrl,这里先兼容一下吧
    fun <S> getService(service: Class<S>, baseUrl: String): S {
        val apiService = apiServiceCache.get(baseUrl) as S
        if (apiService != null) {
            return apiService
        }
        val retrofit = retrofitsCache.get(baseUrl) ?: createRetrofit(baseUrl)
        val finalService = retrofit.create(service)
        apiServiceCache.put(baseUrl, finalService)
        return finalService
    }

    inline fun <reified S> getService(baseUrl: String): S = getService(S::class.java, baseUrl)
}