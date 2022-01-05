package com.keelim.compose.basic

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keelim.compose.R

@Composable
fun StringResourceDemo(){
    Text(
        text = stringResource(
            id = R.string.title_activity_sample,
            formatArgs = arrayOf(
                stringResource(id = R.string.title_activity_sample)
            ),
        ),
        modifier = Modifier.padding(16.dp)
    )
    stringArrayResource(id = R.array.sample).forEach { value ->
        Text(text = value)
    }
}

@Preview
@Composable
fun PreviewStringResource(){
    StringResourceDemo()
}

