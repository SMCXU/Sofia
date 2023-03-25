package com.u.app.network.repository

import com.u.app.network.Urls
import com.u.app.network.model.LotteryTabModel
import com.u.sofia.BaseModel
import com.u.sofia.HttpClient
import com.u.sofia.HttpResult
import com.u.sofia.repository.BaseRepository
import com.u.app.network.service.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author: Mr.U
 * @date: 2023/3/22
 * @description： 一种BaseModel数据结构一个Repository
 */
object UserRepository: BaseRepository() {

    private val service = HttpClient.getService<UserService>(Urls.API_BASEURL)

    override fun <T : Any> executeResponse(response: Any): HttpResult<T> {
        return if ((response as BaseModel<T>).code != 0) {
            HttpResult.Failure(response.toString())
        } else {
            HttpResult.Success(response.data)
        }
    }

    suspend fun getLotteryTabs(): HttpResult<LotteryTabModel> {
        return withContext(Dispatchers.IO) {
            executeResponse(service.getLotteryTabs())
        }
    }


}