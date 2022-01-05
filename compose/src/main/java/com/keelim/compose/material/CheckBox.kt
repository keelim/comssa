package com.keelim.compose.material

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxDemo() {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(checked = isChecked.value, onCheckedChange = { bool ->
        isChecked.value = bool
    },
        enabled = false
    )
}

@Composable
fun CheckBoxDemo2() {
    val isChecked = remember { mutableStateOf(false) }
    Row(modifier = Modifier.clickable {
        isChecked.value = isChecked.value.not()
    }){
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { bool ->
                isChecked.value = bool
            }
        )
        Text(text = "Notify me of updates",
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewCheckBoxDemo() {
    CheckBoxDemo()
}

@Preview
@Composable
fun PreviewCheckBoxDemo2() {
    CheckBoxDemo2()
}