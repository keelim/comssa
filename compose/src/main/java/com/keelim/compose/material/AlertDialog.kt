package com.keelim.compose.material

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlertDialogDemo() {
    val showingDialog = remember { mutableStateOf(false) }
    AlertDialog(
        backgroundColor = Color.White,
        shape = RoundedCornerShape(12.dp),
        contentColor = Color.Black,
        onDismissRequest = {
            showingDialog.value = false
        },
        text = {
            Text(text = "Body message")
        },
        title = {
            Text(text = "Title")
        },
        buttons = {
            Row(horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Close",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            showingDialog.value = false
                        })
            }
        }
    )
    Button(onClick = {
        showingDialog.value = true
    }) {
        Text(
            text = "Show dialog"
        )
    }

}

@Preview
@Composable
fun PreviewAlertDialog() {
    AlertDialogDemo()
}