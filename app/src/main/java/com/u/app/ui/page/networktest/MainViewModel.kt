package com.u.app.ui.page.networktest

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.u.app.network.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author: Mr.U
 * @date: 2023/3/25
 * @description：
 */
//用hilt吧，不用再额外处理viewModel的生命周期
@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _state = mutableStateOf(MainPageState())
    val state: MutableState<MainPageState> = _state
    private var job: Job? = null

    fun getTabs() {
        job = viewModelScope.launch {
            Log.d("MainViewModel", "getTabs: ${Thread.currentThread().name}")
            _state.value = _state.value.copy(isLoading = true)
            //太快了，阻塞一下
            delay(3000)
            val result = UserRepository.getLotteryTabs()
            _state.value = _state.value.copy(model = result, isLoading = false)
        }
    }

    fun cancelRequest() {
        job?.cancel()
        _state.value = _state.value.copy(isLoading = false)

    }
}