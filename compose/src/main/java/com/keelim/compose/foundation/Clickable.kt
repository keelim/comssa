package com.keelim.compose.foundation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ClickableDemo() {
    Text(
        text = "Clickable",
        modifier = Modifier
            .padding(16.dp)
            .clickable(
                onClick = {

                },
                enabled = false,
                onClickLabel = "Click to open document"
            )
    )
}