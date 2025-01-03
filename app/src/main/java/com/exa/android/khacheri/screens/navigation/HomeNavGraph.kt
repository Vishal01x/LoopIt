package com.exa.android.khacheri.screens.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.exa.android.khacheri.R
import com.exa.android.khacheri.mvvm.main.ViewModel.ChatViewModel
import com.exa.android.khacheri.screens.Main.Home.ChatDetail.DetailChat
import com.exa.android.khacheri.screens.Main.Home.ChatDetail.ProfileScreen
import com.exa.android.khacheri.screens.Main.Home.HomeScreen
import com.exa.android.khacheri.screens.Main.Home.SearchScreen
import com.exa.android.khacheri.screens.Main.Home.ZoomPhoto
import com.exa.android.khacheri.utils.Call
import com.exa.android.khacheri.utils.ChatInfo
import com.exa.android.khacheri.utils.HomeRoute

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(startDestination = HomeRoute.ChatList.route, route = "home") {
        composable(HomeRoute.ChatList.route) {
            val viewModel : ChatViewModel = hiltViewModel()
            val chatList = listOf("Vishal", "Kanhaiya", "Joe Tam", "Holder", "Smith Darklew")
            HomeScreen(navController, viewModel)
        }

        composable(HomeRoute.ZoomImage.route) { backStackEntry ->
            val imageId = backStackEntry.arguments?.getString("imageId")
            val resourceId = imageId?.toIntOrNull() ?: R.drawable.ic_launcher_background
            ZoomPhoto(imageId = resourceId) {
                navController.popBackStack()
            }
        }

        composable(
            HomeRoute.ChatDetail.route,
            arguments = listOf(navArgument("userId"){
                type = NavType.StringType
            })
            ) {backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            DetailChat(navController, userId!!)
        }

        composable(HomeRoute.SearchScreen.route){
            val viewModel : ChatViewModel = hiltViewModel()
            SearchScreen(navController,viewModel)
        }

        chatInfoNavGraph(navController)
    }
}

fun NavGraphBuilder.chatInfoNavGraph(navController: NavHostController) {
    navigation(startDestination = ChatInfo.ProfileScreen.route, route = "chat") {
        composable(ChatInfo.ProfileScreen.route) {
            ProfileScreen(
//                "fjidjf",
//                onMediaClick = { navController.navigate(ChatInfo.ChatMedia.route) },
//                onCallClick = { navController.navigate(Call.VoiceCall.route) },
//                onMediaVisibilityClick = { navController.navigate(ChatInfo.MediaVisibility.route) },
//                onBlockClick = { navController.navigate(ChatInfo.BlockUser.route) }
            )
        }
        /*composable(ChatInfo.ChatMedia.route) { MediaScreen() }
        composable(ChatInfo.MediaVisibility.route) { MediaVisibilityScreen() }
        composable(ChatInfo.BlockUser.route) { BlockUserScreen() }
        composable(Call.VoiceCall.route) { CallScreen() }*/
    }
}


