package com.u.sofia
import com.google.gson.annotations.SerializedName


/**
 * @author: Mr.U
 * @date: 2023/3/22
 * @description：
 */
data class BaseModel<T>(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: T,
    @SerializedName("message")
    val msg: String
)

class Data