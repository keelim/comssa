package com.keelim.compose.basic

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.booleanResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerArrayResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.unit.dp
import com.keelim.compose.R

@Composable
fun PrimitiveResourceDemo() {
    repeat(integerResource(id = androidx.appcompat.R.integer.abc_config_activityDefaultDur)) {
        Text(text = it.toString())
    }

    integerArrayResource(id = R.array.sample).forEach {
        Text(text = it.toString(),
            modifier = Modifier.padding(16.dp)
        )
    }
    
    Text(text = "is enabled ${booleanResource(id = androidx.appcompat.R.bool.abc_action_bar_embed_tabs)}",
        modifier = Modifier.padding(16.dp)
    )

    Text(text = "Adding some padding",
        modifier = Modifier.padding(dimensionResource(id = androidx.appcompat.R.dimen.abc_action_bar_content_inset_with_nav))
    )
}