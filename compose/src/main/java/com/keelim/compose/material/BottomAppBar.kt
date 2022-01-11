package com.keelim.compose.material

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun BottomAppBarDemo() {
    BottomAppBar(
        elevation = 12.dp,
        contentColor = Color.Black
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun BottomAppBarDemo2() {
    Scaffold(
        bottomBar = {
            BottomAppBar(contentColor = Color.White,
                backgroundColor = Color.Black,
                cutoutShape = CircleShape) {

            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Done, contentDescription = "my description")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        content = {}
    )
}

@Preview
@Composable
fun PreviewBottomAppBar() {
    BottomAppBarDemo()
}

@Preview
@Composable
fun PreviewBottomAppBar2() {
    BottomAppBarDemo2()
}