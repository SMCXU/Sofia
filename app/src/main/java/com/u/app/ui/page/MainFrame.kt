package com.u.app.ui.page

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.u.app.network.model.LotteryTabModel
import com.u.app.utils.showToast
import com.u.sofia.HttpResult

/**
 * @author: Mr.U
 * @date: 2023/3/25
 * @description：
 */

@Composable
fun MainFrame(viewModel: MainViewModel = hiltViewModel()) {
    val state by viewModel.state
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Button(onClick = {
                    viewModel.getTabs()
                }) {
                    Text(text = "请求网络")
                }
                Button(onClick = {
                    viewModel.cancelRequest()
                }) {
                    Text(text = "取消请求")
                }

            }
            Text(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight(),
                text = "${state.model?.toString()}"
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            when (state.model) {
                is HttpResult.Error->{
                    showToast("${(state.model as HttpResult.Error).e.cause?.message}")
                }
                is HttpResult.Failure->{
                    showToast((state.model as HttpResult.Failure).reason)
                }
                else->{

                }
            }
        }

    }

}