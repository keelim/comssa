package com.keelim.compose.ui.myWidget.snackbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MySnackBar(
    message:String,
    actionMessage: String = "",
    click: () -> Unit = {}
){
    Column{
        Snackbar(
            action = {
                if(actionMessage.isNotEmpty()){
                    Button(
                        onClick = click
                    ){
                        Text(actionMessage)
                    }
                }
            }
        ,modifier = Modifier.padding(8.dp)
        ){
            Text(message)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMySnackBar(){
    MaterialTheme{
        MySnackBar(
            message = "This is MySnackBar",
            actionMessage = "This is Action"
        )
    }
}