package com.keelim.compose.material

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardDemo(){
    Card(
        shape = RoundedCornerShape(3.dp),
        backgroundColor = Color.Yellow,
        contentColor = Color.Red,
        border = BorderStroke(2.dp, Color.Blue),
        elevation = 12.dp
    ){
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp
            )
        )
        Spacer(modifier = Modifier.height(8.dp) )
        Text(
            text = "Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun CardDemo1(){
    MaterialTheme{
        CardDemo()
    }
}