package com.exa.android.khacheri.screens.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.exa.android.khacheri.screens.auth.ForgetPasswordScreen
import com.exa.android.khacheri.screens.auth.LoginScreen
import com.exa.android.khacheri.screens.auth.RegisterScreen
import com.exa.android.khacheri.utils.AuthRoute

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(startDestination = AuthRoute.Login.route, route = "auth") {
        composable(AuthRoute.Login.route) { LoginScreen(navController) }
        composable(AuthRoute.Register.route) { RegisterScreen(navController) }
        composable(AuthRoute.ForgetPassword.route) { ForgetPasswordScreen(navController) }
    }
}


