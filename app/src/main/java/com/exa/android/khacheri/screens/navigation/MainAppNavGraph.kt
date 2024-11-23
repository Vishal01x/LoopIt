package com.exa.android.khacheri.screens.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.exa.android.khacheri.screens.Main.SettingScreen
import com.exa.android.khacheri.screens.Main.StatusScreen
import com.exa.android.khacheri.utils.HomeRoute
import com.exa.android.khacheri.utils.MainRoute

fun NavGraphBuilder.mainAppNavGraph(navController: NavHostController) {
    navigation(startDestination = "home", route = "main_app") {
        homeNavGraph(navController)

        composable(MainRoute.Profile.route) {
            StatusScreen(navController)
        }
        composable(MainRoute.Setting.route) {
            SettingScreen(navController)
        }
    }
}

//object MainRoutes {
//    const val MainApp = "main_app"
//    const val Profile = "profile"
//    const val Settings = "settings"
//}
