package com.keelim.compose.basic

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun DrawbleResourceDemo(){
    Icon(
        painter = painterResource(id = androidx.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha),
        contentDescription = "My content description"
    )
}

