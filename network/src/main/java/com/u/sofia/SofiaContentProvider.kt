package com.u.sofia

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

/**
 * @author: Mr.U
 * @date: 2023/3/25
 * @description：免侵入初始化，
 * 但是好像没啥卵用，配置文件NetworkConfig还是要与外界接触
 */
class SofiaContentProvider:ContentProvider() {

    override fun onCreate(): Boolean {
        Sofia.instance.init(context!!.applicationContext)
        return true
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        return null
    }

    override fun getType(p0: Uri): String? {
        return null
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        return null
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        return 0
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        return 0
    }
}