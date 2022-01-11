@file:OptIn(ExperimentalMaterial3Api::class)

package com.keelim.compose.material

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldDemo() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "my description"
                )
                Text(text = "Body Content")
            }
        },
        floatingActionButtonPosition = androidx.compose.material.FabPosition.End,
        content = {

        }
    )
}


@Composable
fun ScaffoldDemo2() {
    Scaffold(
        drawerGesturesEnabled = false,
        topBar = {

        },
        drawerContent = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Text(text = "My Drawer")
            }
        },
        drawerShape = RoundedCornerShape(8.dp),
        drawerBackgroundColor = Color.White,
        drawerContentColor = Color.Black,
        drawerElevation = 8.dp,
        drawerScrimColor = Color.Red,
        content = {
            Text(text = "Compose Academy")
        }
    )
}

@Composable
fun ScaffoldDemo3() {
    Scaffold(bottomBar = {
        BottomAppBar {
            Text(
                text = "Jetpack Compose",
                modifier = Modifier.padding(16.dp)
            )
        }
    },
        contentColor = Color.Black,
        backgroundColor = Color.White
    ) {

    }
}


@Preview
@Composable
fun PreviewScaffoldDemo() {
    MaterialTheme {
        ScaffoldDemo()
    }
}

@Preview
@Composable
fun PreviewScaffoldDemo2() {
    MaterialTheme {
        ScaffoldDemo2()
    }
}

@Preview
@Composable
fun PreviewScaffoldDemo3() {
    MaterialTheme {
        ScaffoldDemo3()
    }
}