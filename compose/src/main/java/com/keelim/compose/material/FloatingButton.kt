package com.keelim.compose.material

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FloatingButtonDemo() {
    FloatingActionButton(
        onClick = {},
        backgroundColor = Color.Red,
        contentColor = Color.White,
        shape = RectangleShape
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "my description"
        )
    }
}

@Composable
fun FloatingButtonDemo2(){
    ExtendedFloatingActionButton(text = {
        Text(text = "Extended")
    }, onClick = {
        
    },
    icon = { Icon(
        imageVector = Icons.Filled.Star,
        contentDescription = "my description"
    )})
}

@Preview
@Composable
fun PreviewFloatingButton() {
    MaterialTheme {
        FloatingButtonDemo()
    }
}

@Preview
@Composable
fun PreviewFloatingButton2() {
    MaterialTheme {
        FloatingButtonDemo2()
    }
}