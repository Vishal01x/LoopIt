package com.exa.android.khacheri.old.state

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.window.DialogProperties

@Composable
fun ShowDialog(
    isDialog: DialogState,
    onDismiss: () -> Unit
) {
    if (isDialog == DialogState.ALERT_DIALOG) {
        var textState by remember { mutableStateOf(TextFieldValue("")) } // Use by for mutable state

        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = "Add Friends")
            },
            text = { // Specify the text parameter
                OutlinedTextField(
                    value = textState,
                    onValueChange = { textState = it },
                    label = { Text(text = "Write Friend Name") },
                    modifier = Modifier.fillMaxWidth()
                )
            },
            confirmButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = "Add")
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = "Cancel")
                }
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        )
    }
}
