package com.keelim.compose.setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun SettingTitle(title: @Composable () -> Unit) {
    ProvideTextStyle(value = MaterialTheme.typography.titleMedium) {
        title()
    }
}

@Composable
internal fun SettingSubTitle(subtitle: @Composable () -> Unit) {
    ProvideTextStyle(value = MaterialTheme.typography.bodyMedium) {
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium,
            content = subtitle
        )
    }
}

@Composable
internal fun RowScope.SettingTitleText(
    title: @Composable () -> Unit,
    subtitle: @Composable (() -> Unit)?,
) {
    Column(
        modifier = Modifier.Companion.weight(1f),
        verticalArrangement = Arrangement.Center,
    ) {
        SettingTitle(title)
        subtitle?.let {
            Spacer(modifier = Modifier.size(2.dp))
            SettingSubTitle(subtitle)
        }
    }
}