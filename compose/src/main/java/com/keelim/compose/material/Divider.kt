package com.keelim.compose.material

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DividerDemo() {
    Divider(
        color = Color.Red,
        thickness = 12.dp,
        startIndent = 12.dp
    )
}

@Preview
@Composable
fun PreviewDivider() {
    DividerDemo()
}