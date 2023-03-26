package com.u.app.ui.page.explore

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.u.app.ui.page.networktest.MainPageState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author: Mr.U
 * @date: 2023/3/27
 * @description：
 */
class ExploreViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateListOf<String>()
    val state = _state

    fun refreshData() {
        viewModelScope.launch(Dispatchers.Main) {
            delay(2000)
            _state.clear()
            val list = mutableListOf<String>()
            repeat(10) {
                list.add("第 $it 项")
                Log.d("Mr.U", "refreshData: $it")
            }
            _state.addAll(list)


        }
    }

    fun nextPageData() {
        viewModelScope.launch(Dispatchers.Main) {
            delay(2000)
            val size = _state.size
            val list = mutableListOf<String>()
            for (a in size..size + 10) {
                list.add("第 $a 项")
                Log.d("Mr.U", "nextPageData: $a")
            }
            _state.addAll(list)


        }
    }

}