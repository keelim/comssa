package com.keelim.compose.material

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBarDemo() {
    TopAppBar(
        title = {
            Text(text = "Jetpack Compose")
        },
        backgroundColor = Color.Black,
        contentColor = Color.White,
        elevation = 12.dp,
        actions = {
            Text(
                text = "Save", modifier = Modifier
                    .padding(8.dp)
                    .clickable(onClick = {

                    }),
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Back Arrow"
                )
            }
        }
    )
}

@Preview
@Composable
fun PreviewTopAppbar() {
    TopAppBarDemo()
}