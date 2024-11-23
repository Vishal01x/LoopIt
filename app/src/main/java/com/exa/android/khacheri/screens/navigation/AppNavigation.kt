package com.exa.android.khacheri.screens.navigation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.exa.android.khacheri.screens.navigation.component.CustomBottomNavigationBar
import com.exa.android.khacheri.utils.HomeRoute
import com.exa.android.khacheri.utils.MainRoute

@Composable
fun AppNavigation(navController: NavHostController, isLoggedIn: Boolean) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
    Scaffold(
        bottomBar = {
            if(currentDestination == HomeRoute.ChatList.route || currentDestination == MainRoute.Profile.route) {
                CustomBottomNavigationBar(navController) {

                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = if (isLoggedIn) "main_app" else "auth",
            modifier = Modifier.padding(paddingValues)
        ) {
            authNavGraph(navController)
            mainAppNavGraph(navController)
        }
    }
}





