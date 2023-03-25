package com.u.sofia.util

import android.content.Context
import android.net.ConnectivityManager

/**
 * @author: Mr.U
 * @date: 2023/3/25
 * @description：
 */
object NetworkUtils {

    fun isNetworkConnected(context: Context?): Boolean {
        if (context != null) {
            // 获取手机所有连接管理对象(包括对wi-fi,net等连接的管理)
            val manager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            // 获取NetworkInfo对象
            val networkInfo = manager.activeNetworkInfo
            //判断NetworkInfo对象是否为空
            if (networkInfo != null) return networkInfo.isAvailable
        }
        return false
    }

}