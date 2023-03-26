package com.u.app.ui.widgets

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

/**
 * @author: Mr.U
 * @date: 2023/3/26
 * @description：带加载刷新的ListView
 */
@Composable
fun <T> BaseListView(
    data: MutableList<T>?,
    loading: Boolean = false,
    onRefresh: () -> Unit,
    onLoadMore: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (value:String,position:Int) -> Unit
) {
    if (data == null) {
        return
    }
    val listState = rememberLazyListState()
    var isRefreshing by remember { mutableStateOf(false) }
    LaunchedEffect(loading) {
        if (loading && !isRefreshing) {
            listState.animateScrollToItem(data.size - 1)
        }
    }
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = {
            isRefreshing = true
            onRefresh()
            isRefreshing = false
        }
    ) {
        LazyColumn(
            modifier = modifier,
            state = listState,
        ) {
            //todo 这块儿重复了，待优化
            items(data.size) { index ->
                if (index == data.size - 1) {
                    if (loading) {
                        Box(Modifier.fillParentMaxWidth()) {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    } else {
                        //loadMore view
                        onLoadMore()
                    }
                }else{
                    content(data[index] as String,index)
                }
            }
        }
    }
}

