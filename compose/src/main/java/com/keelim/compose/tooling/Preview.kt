package com.keelim.compose.tooling

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "My Preview",
    showBackground = true,
    backgroundColor = 0x989a82,
    device = Devices.AUTOMOTIVE_1024p,
    group = "Profile",
    uiMode = UI_MODE_NIGHT_YES,
    widthDp = 200,
    heightDp = 200,
)
@Composable
fun DefaultPreview(){
    Text(text = "Hello Compose!")
}