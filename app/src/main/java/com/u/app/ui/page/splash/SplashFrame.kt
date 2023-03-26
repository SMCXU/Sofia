package com.u.app.ui.page.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.u.app.ui.theme.main_bg
import com.u.sofia.R
import kotlinx.coroutines.delay

/**
 * @author: Mr.U
 * @date: 2023/3/26
 * @description：
 */
@Composable
fun SplashFrame(onNextPage: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(main_bg)
    ) {
        LaunchedEffect(Unit) {
            delay(1000)
            onNextPage.invoke()
        }
        Image(
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 45.dp),
            painter = painterResource(id = R.mipmap.splash_activity_logo),
            contentDescription = "logo"
        )
    }
}