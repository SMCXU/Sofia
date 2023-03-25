package com.u.app.network.model

import com.google.gson.annotations.SerializedName


/**
 * @author: Mr.U
 * @date: 2023/3/25
 * @description：
 */
data class LotteryTabModel(
    @SerializedName("default_index")
    val defaultIndex: Int,
    @SerializedName("pay")
    val pay: Pay,
    @SerializedName("top")
    val top: List<Top>
){
    override fun toString(): String {
        return "LotteryTabModel(defaultIndex=$defaultIndex, pay=$pay, top=$top)"
    }
}

data class Pay(
    @SerializedName("rube_scheme")
    val rubeScheme: String,
    @SerializedName("service_pic")
    val servicePic: String,
    @SerializedName("vip_center_scheme")
    val vipCenterScheme: String
){
    override fun toString(): String {
        return "Pay(rubeScheme='$rubeScheme', servicePic='$servicePic', vipCenterScheme='$vipCenterScheme')"
    }
}

data class Top(
    @SerializedName("api")
    val api: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("label")
    val label: String,
    @SerializedName("newsType")
    val newsType: String,
    @SerializedName("newsTypeStr")
    val newsTypeStr: String,
    @SerializedName("tab_type")
    val tabType: String
) {
    override fun toString(): String {
        return "Top(api='$api', id='$id', label='$label', newsType='$newsType', newsTypeStr='$newsTypeStr', tabType='$tabType')"
    }
}