package com.keelim.compose.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RowDemo() {
    Row(modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Top)
    {
        Text(text = "Hello",
            modifier = Modifier.align(Alignment.Bottom))
        Text(text = "World", modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
fun PreviewRow() {
    RowDemo()
}