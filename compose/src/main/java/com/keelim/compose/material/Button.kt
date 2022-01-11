package com.keelim.compose.material

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ButtonDemo(){
    Button(
        onClick = {

        }, border = BorderStroke(2.dp, Color.Red)
    ){
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ButtonDemo2(){
    val disabled = remember { mutableStateOf(false) }
    Button(
        onClick = {
            disabled.value = true
        },
        enabled = disabled.value.not(),
        shape = CutCornerShape(12.dp)
    ){
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ButtonDemo3(){
    OutlinedButton(onClick = {}) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ButtonDemo4(){
    TextButton(onClick = {}) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun PreviewButton(){
    MaterialTheme {
        ButtonDemo()
    }
}

@Preview
@Composable
fun PreviewButton2(){
    MaterialTheme {
        ButtonDemo2()
    }
}

@Preview
@Composable
fun PreviewButton3(){
    MaterialTheme {
        ButtonDemo3()
    }
}

@Preview
@Composable
fun PreviewButton4(){
    MaterialTheme {
        ButtonDemo4()
    }
}