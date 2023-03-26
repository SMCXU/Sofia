package com.u.app.ui.widgets

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import kotlin.math.log

/**
 * @author: Mr.U
 * @date: 2023/3/27
 * @description：
 */
val bg = mutableListOf<Color>(
    Color.Cyan,
    Color.Blue,
    Color.Magenta,
    Color.Yellow,
    Color.Gray
)

@Composable
fun BaseItemView(content: String, position: Int) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(bg[position % (bg.size)]),
        text = content,
        color = Color.White,
        textAlign = TextAlign.Center
    )
//    Log.d("Mr.U", "BaseItemView: --$content --- $position")

}