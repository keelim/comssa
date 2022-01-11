package com.keelim.compose.layout

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SpacerDemo(){
    Spacer(
        modifier = Modifier.height(16.dp)
    )

    Spacer(
        modifier = Modifier.width(16.dp)
    )
}

@Preview
@Composable
fun PreviewSpacer(){
    SpacerDemo()
}