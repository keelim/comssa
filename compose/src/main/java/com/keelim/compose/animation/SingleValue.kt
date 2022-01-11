package com.keelim.compose.animation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun SingleValueDemo(){
    val enabled = remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
//            .background(animate(if(enabled.value) Color.Green else Color.Red))
            .clickable {
                enabled.value = enabled.value.not()
            }
    )
}
