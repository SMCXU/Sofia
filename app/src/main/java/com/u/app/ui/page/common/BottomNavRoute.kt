package com.u.app.ui.page.common

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.u.sofia.R

/**
 * @author: Mr.U
 * @date: 2023/3/26
 * @description：
 */
sealed class BottomNavRoute(
    var routeName: String,
    @StringRes var stringId: Int,
    var icon: ImageVector
) {
    object Match: BottomNavRoute(RouteName.Match, R.string.match, Icons.Default.Home)
    object EXPLORE: BottomNavRoute(RouteName.EXPLORE, R.string.explore, Icons.Default.Menu)
    object DATA: BottomNavRoute(RouteName.DATA, R.string.data, Icons.Default.DateRange )
    object Mine: BottomNavRoute(RouteName.MINE, R.string.mine, Icons.Default.Person)
}