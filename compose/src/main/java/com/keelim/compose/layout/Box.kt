package com.keelim.compose.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxDemo() {
    Box(
        modifier = Modifier
            .size(200.dp, 200.dp)
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(text = "Item", modifier = Modifier.align(Alignment.TopCenter))
        Text(text = "This is another item", modifier = Modifier.align(Alignment.BottomEnd))
    }
}

@Preview
@Composable
fun PreviewBox(){
    BoxDemo()
}
