package com.u.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.u.app.ui.page.home.HomeFrame
import com.u.app.ui.page.networktest.MainFrame
import com.u.app.ui.page.splash.SplashFrame
import com.u.app.ui.theme.SofiaTheme
import com.u.app.ui.theme.custom.CustomColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SofiaTheme {
                var isSplash by remember {
                    mutableStateOf(true)
                }
                if (isSplash) {
                    SplashFrame {
                        isSplash = false
                    }
                } else {
                    HomeFrame()
                }
            }
        }
    }
}