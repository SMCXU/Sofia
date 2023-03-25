package com.u.sofia

import android.content.Context

/**
 * @author: Mr.U
 * @date: 2023/3/25
 * @description：
 */
class Sofia private constructor() {
    private var context: Context? = null

    companion object {
        val instance = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder = Sofia()
    }

    fun init(app: Context) = apply {
        context = app
        return this
    }

    /** 获取全局上下文  */
    fun getContext(): Context {
        if (context == null) {
            throw NullPointerException( "无Context,查看SofiaContentProvider")
        }
        return context!!
    }
}