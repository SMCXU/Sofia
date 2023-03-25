package com.u.sofia

import java.util.concurrent.ConcurrentHashMap

/**
 * @author: Mr.U
 * @date: 2023/3/23
 * @description：
 */
class NetworkConfig {

    private var CONNECT_TIMEOUT = 10_1000L
    private var READ_TIMEOUT = 10_1000L
    private var WRITE_TIMEOUT = 10_1000L

    //无网络缓存持续时间默认一天吧
    private var CACHE_DURATION = 60 * 60 * 24

    //缓存大小50M
    private var CACHE_SIZE = 50 * 1024 * 1024L

    private var DEBUG = false
    private var header = ConcurrentHashMap<String, String>()


    companion object {
        fun getInstance() = InstanceHelper.sInstance
    }

    object InstanceHelper {
        val sInstance = NetworkConfig()
    }

    fun updateHeader(map: Map<String, String>): NetworkConfig {
        map.forEach {
            header[it.key] = it.value
        }
        return this@NetworkConfig
    }

    fun getHeader(): ConcurrentHashMap<String, String> {
        return header
    }

    fun debug(debug: Boolean): NetworkConfig {
        DEBUG = debug
        return this@NetworkConfig
    }

    fun isDebug(): Boolean {
        return DEBUG
    }

    fun connectTime(t: Long): NetworkConfig {
        CONNECT_TIMEOUT = t
        return this@NetworkConfig
    }

    fun getConnectTime(): Long {
        return CONNECT_TIMEOUT
    }


    fun readTime(t: Long): NetworkConfig {
        READ_TIMEOUT = t
        return this@NetworkConfig
    }

    fun getReadTime(): Long {
        return READ_TIMEOUT
    }

    fun writeTime(t: Long): NetworkConfig {
        WRITE_TIMEOUT = t
        return this@NetworkConfig
    }

    fun getWriteTime(): Long {
        return WRITE_TIMEOUT
    }

    fun cacheDuration(d: Int): NetworkConfig {
        CACHE_DURATION = d
        return this@NetworkConfig
    }

    fun getCacheDuration(): Int {
        return CACHE_DURATION
    }

    fun cacheSize(size: Int): NetworkConfig {
        CACHE_DURATION = size
        return this@NetworkConfig
    }

    fun getCacheSize(): Long {
        return CACHE_SIZE
    }
}