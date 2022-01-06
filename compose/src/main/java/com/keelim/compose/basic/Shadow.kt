package com.keelim.compose.basic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun ShadowDemo(){
    Box(
        modifier = Modifier.size(100.dp, 100.dp)
            .background(Color.White)
            .padding(16.dp)
            .shadow(elevation = 4.dp, shape = RectangleShape)
    )
}