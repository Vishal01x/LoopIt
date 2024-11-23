package com.exa.android.khacheri.screens.Main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.exa.android.khacheri.utils.MainRoute

@Composable
fun StatusScreen(navController: NavController) {
    Row(modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = {
            navController.navigate(MainRoute.Home.route)
        }) {
            Text("Home",
                modifier = Modifier.align(Alignment.Top))
        }

        Button(onClick = {
            navController.navigate("auth"){
                popUpTo("main_app"){
                    inclusive = true
                }
            }
        }) {
            Text("LogOut",
                modifier = Modifier.align(Alignment.Bottom))
        }
    }
}