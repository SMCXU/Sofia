package com.u.app.ui.theme.custom

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

/**
 * @author: Mr.U
 * @date: 2023/3/26
 * @description：颜色放在这里，统一管理，多套主题可用这个
 */
class CustomColor(
    colorBg: Color,
    textColor: Color,
) {
    val bg_match by mutableStateOf(colorBg)
    val tvc_match by mutableStateOf(textColor)

    fun customDarkTheme(
        bg_match: Color = Color(0xFFA243B3),
        tvc_match: Color = Color.Green,
    ): CustomColor = CustomColor(
        tvc_match, tvc_match
    )

    fun customLightTheme(
        bg_match: Color = Color.White,
        tvc_match: Color = Color.Black,
    ): CustomColor = CustomColor(
        bg_match, tvc_match
    )
}



