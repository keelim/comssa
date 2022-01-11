package com.keelim.compose.material

import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SwitchDemo(){
    val isChecked = remember { mutableStateOf(false) }
    Switch(
        checked = isChecked.value,
        onCheckedChange = { bool ->
            isChecked.value = bool
        },
        enabled = false,
    )
}


@Preview
@Composable
fun PreviewSwitch(){
    SwitchDemo()
}