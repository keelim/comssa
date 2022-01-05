package com.keelim.compose.material

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonDemo() {
    val state = remember { mutableStateOf("") }
    val text = "안녕하세요"
    Row(modifier = Modifier.padding(18.dp)){
        RadioButton(
            selected = state.value == text,
            onClick = {
                state.value = text
            },
            enabled = false,
        )
        Text(
            text = text,
            modifier =  Modifier.padding(start = 18.dp)
        )
    }
}

@Composable
fun RadioButtonDemo2(){
    val state = remember { mutableStateOf("")}
    val items = listOf("안녕하세여")
    Column {
        items.forEach { item ->
            Row(modifier = Modifier.padding(10.dp)){
                RadioButton(
                    selected = state.value == item,
                    onClick = {
                        state.value = item
                    }
                )
                Text(
                    text = item,
                    modifier = Modifier.padding(start = 18.dp)
                )
            }

        }
    }
}

@Composable
@Preview
fun PreviewRadioButton() {
    RadioButtonDemo()
}

@Composable
@Preview
fun PreviewRadioButton2() {
    RadioButtonDemo2()
}