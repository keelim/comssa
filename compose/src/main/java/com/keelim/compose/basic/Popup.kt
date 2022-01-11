package com.keelim.compose.basic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties

@Composable
fun PopupDemo() {
    Popup(alignment = Alignment.Center,
        offset = IntOffset(16, 0),
        properties = PopupProperties(focusable = true),
        onDismissRequest = {
        }
    ) {
        Box(
            modifier = Modifier
                .size(200.dp, 50.dp)
                .background(
                    shape = RoundedCornerShape(16.dp),
                    color = Color.Black
                )
        ) {
            Text(
                text = "Pop up!",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White
            )
        }
    }
}