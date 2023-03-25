package com.u.app.network.service

import com.u.app.network.model.LotteryTabModel
import com.u.sofia.BaseModel
import retrofit2.http.GET

/**
 * @author: Mr.U
 * @date: 2023/3/22
 * @description：
 */
interface UserService {
    @GET("v2/lottery/tabs")
    suspend fun getLotteryTabs(): BaseModel<LotteryTabModel>
}