package com.keelim.compose.material

import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SliderDemo(){
    val state = remember {
        mutableStateOf(0f)
    }
    Slider(value = state.value, onValueChange = {
        state.value = it
    },
        valueRange = 0f..5f,
        steps = 3,
        colors = SliderDefaults.colors(
            thumbColor = Color.Red,
            inactiveTickColor = Color.Red,
            activeTrackColor = Color.Red,
            activeTickColor = Color.Red,
            inactiveTrackColor = Color.Red
        )
    )
}

@Preview
@Composable
fun PreviewSliderDemo(){
    SliderDemo()
}