package com.keelim.compose.material

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SnackbarDemo(){
    Snackbar(
        content = {
            Text(text = "This is a snackbar", color = Color.Black)
        },
        contentColor = Color.Gray,
        shape = RoundedCornerShape(4.dp),
        backgroundColor = Color.White,
        elevation = 8.dp
    )
}

@Preview()
@Composable
fun PreviewSnackbar(){
    MaterialTheme {
        SnackbarDemo()
    }
}