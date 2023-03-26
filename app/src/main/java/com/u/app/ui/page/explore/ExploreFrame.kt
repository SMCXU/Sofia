package com.u.app.ui.page.explore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.u.app.ui.widgets.BaseItemView
import com.u.app.ui.widgets.BaseListView

/**
 * @author: Mr.U
 * @date: 2023/3/26
 * @description：
 */
@Composable
fun ExploreFrame(
    navCtrl: NavHostController,
    scaffoldState: ScaffoldState,
    viewModel: ExploreViewModel = hiltViewModel()
) {

    BaseListView<String>(
        data = viewModel.state,
        onRefresh = {
            viewModel.refreshData()
        },
        onLoadMore = {
            viewModel.nextPageData()
        }) { content,index->
        BaseItemView(content,index)
    }
    viewModel.refreshData()

}

