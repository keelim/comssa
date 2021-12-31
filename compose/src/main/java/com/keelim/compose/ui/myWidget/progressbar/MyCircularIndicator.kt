package com.keelim.compose.ui.myWidget.progressbar

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyCircularIndicator(){
    CircularProgressIndicator( )
}

@Preview(showBackground = true)
@Composable
private fun PreviewCircularIndicator(){
    MaterialTheme{
        MyCircularIndicator()
    }
}