package com.keelim.compose.layout

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ColumnDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                rememberScrollState(),
                orientation = Orientation.Vertical
            )
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello",
            modifier = Modifier.align(Alignment.Start),
        )
        Text(text = "World",
            modifier = Modifier.weight(1f)
        )
        Text(text = "Third",
            modifier = Modifier.weight(2f, fill = false)
        )
    }
}


@Composable
@Preview
fun PreviewColumn() {
    ColumnDemo()
}
