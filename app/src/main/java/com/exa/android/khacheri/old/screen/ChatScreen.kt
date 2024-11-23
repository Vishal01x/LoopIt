package com.exa.android.khacheri.old.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.exa.android.khacheri.R
import com.exa.android.khacheri.old.state.ShowDialog
import com.exa.android.khacheri.old.state.DialogState

@Composable
fun ChatScreen(modifier: Modifier = Modifier) {

    var dialogState by remember { mutableStateOf(DialogState.NONE) }

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        FloatingActionButton(
            onClick = {
               dialogState = DialogState.ALERT_DIALOG
            },
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.BottomEnd),
            shape = RoundedCornerShape(8.dp),
            elevation = FloatingActionButtonDefaults.elevation(8.dp,16.dp)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.add_btn),
                contentDescription = "FAB Btn",
                tint = Color.White
            )
        }
        when(dialogState){
            DialogState.ALERT_DIALOG->{
                ShowDialog(isDialog = dialogState) {
                    dialogState = DialogState.NONE
                }
            }
            DialogState.NONE->{
                // do else part
            }
        }
    }
}