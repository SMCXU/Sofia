package com.u.app.ui.page.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.u.app.ui.page.common.RouteName
import com.u.app.ui.page.explore.ExploreFrame
import com.u.app.ui.page.networktest.MainFrame
import com.u.app.ui.widgets.BottomNavBarView

/**
 * @author: Mr.U
 * @date: 2023/3/26
 * @description：
 */
@Composable
fun HomeFrame(){
    val navCtrl = rememberNavController()
    val navBackStackEntry by navCtrl.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        bottomBar = {
            when (currentDestination?.route) {
                RouteName.Match -> BottomNavBarView(navCtrl = navCtrl)
                RouteName.EXPLORE -> BottomNavBarView(navCtrl = navCtrl)
                RouteName.DATA -> BottomNavBarView(navCtrl = navCtrl)
                RouteName.MINE -> BottomNavBarView(navCtrl = navCtrl)
            }
        },
        content = {
            NavHost(
                modifier = Modifier.background(MaterialTheme.colors.background).padding(it),
                navController = navCtrl,
                startDestination = RouteName.Match
            ) {
                //比赛---sofia测试页
                composable(route = RouteName.Match) {
                    MainFrame(navCtrl, scaffoldState)
                }
                composable(route = RouteName.EXPLORE) {
                    ExploreFrame(navCtrl, scaffoldState)
                }
                composable(route = RouteName.DATA) {
                    MainFrame(navCtrl, scaffoldState)
                }
                composable(route = RouteName.MINE) {
                    MainFrame(navCtrl, scaffoldState)
                }

            }
        },
    )
}