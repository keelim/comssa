package com.keelim.compose.setting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun SettingAction(content: @Composable () -> Unit){
    Box(
        modifier = Modifier.size(64.dp),
        contentAlignment = Alignment.Center
    ){
        content()
    }
}