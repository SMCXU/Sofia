package com.u.app.ui.page.networktest

import com.u.app.network.model.LotteryTabModel
import com.u.sofia.HttpResult

/**
 * @author: Mr.U
 * @date: 2023/3/25
 * @description：
 */
data class MainPageState(
    val isLoading: Boolean = false,
    val model: HttpResult<LotteryTabModel>?=null
)