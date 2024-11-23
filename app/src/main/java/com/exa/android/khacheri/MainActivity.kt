package com.exa.android.khacheri

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.exa.android.khacheri.Authentication.ViewModel.AuthVM
import com.exa.android.khacheri.screens.navigation.AppNavigation
import com.exa.android.khacheri.ui.theme.KhacheriTheme
import com.exa.android.khacheri.utils.HomeRoute
import com.exa.android.khacheri.utils.MainRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        setContent {
            KhacheriTheme {
                App()

            }
        }
    }
}

/*
@Composable
fun Appp() {
    val navContorller = rememberNavController()

    NavHost(navController = navContorller, startDestination = "item") {
        composable(route = "item") {
            ChatListItem {
                navContorller.navigate("zoom/$it")
            }
        }
        composable(route = "zoom/{image}") {
            var image = it.arguments?.getInt("image")
            Log.d("Profile before ", image.toString())
            if(image == null)image = R.drawable.ic_launcher_background
            Log.d("Profile after ", image.toString())
            ZoomUp(image = R.drawable.ic_launcher_background)
        }
    }

}
*/

@Composable
fun App() {

//    val link = intent?.data?.toString()  // Extract deep link here
//    val email = intent?.getStringExtra("email")  // Extract email if needed
//
//    link?.let {
//        // Verify the sign-in link when the app is opened from a deep link
//        if (email != null) {
//            viewModel.verifySignInLink(email, it)
//        }
    
    val viewModel: AuthVM = hiltViewModel()
    val isLoggedIn = viewModel.authStatus.collectAsState().equals(true)
    val navController = rememberNavController()
    OnBackPressed(navController = navController)
    AppNavigation(navController, isLoggedIn)
}


@Composable
fun OnBackPressed(navController: NavController) {
    // Handle back press based on the current screen
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    // Observe the current destination route
    val currentRoute = currentBackStackEntry?.destination?.route
    val context = LocalContext.current
    //Log.d("currentBackStackEntry->onBack", currentRoute.toString())

    // Listen for the back press event
    BackHandler {
        // If on Profile screen, navigate back to Home
        if (currentRoute == MainRoute.Profile.route) {
            navController.navigate(HomeRoute.ChatList.route) {
                // Ensure no back stack history, so user can't navigate back from Home to Profile
                popUpTo(HomeRoute.ChatList.route) { inclusive = true }
            }
        } else if (currentRoute == HomeRoute.ChatList.route) {
            // If on Home screen, finish the activity to close the app
            (context as? Activity)?.finish()
        }
    }
}

/*@Composable
fun AppNavigation(navController: NavHostController, loggedIn: Boolean) {
    Scaffold(
        bottomBar = BottomNavigationBar(navController)
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = if (loggedIn) "main_app" else "auth",
            modifier = Modifier.padding(paddingValues)
        ) {
            navigation(startDestination = AuthRoute.Login.route, route = "auth") {
                composable(AuthRoute.Login.route) {
                    LoginScreen(navController)
                }

                composable(AuthRoute.Register.route) {
                    RegisterScreen(navController)
                }
                composable(AuthRoute.ForgetPassword.route) {
                    ForgetPasswordScreen(navController)
                }
            }

            navigation(startDestination = MainRoute.Home.route, route = "main_app") {
                navigation(startDestination = HomeRoute.ChatList.route, route = "home") {
                    val chatList = listOf(
                        "Vishal",
                        "Kanhaiya",
                        "Joe Tam",
                        "Holder",
                        "Smith Darklew",
                        "Vishal",
                        "Kanhaiya",
                        "Joe Tam",
                        "Holder",
                        "Smith Darklew"
                    )
                    composable(HomeRoute.ChatList.route) {
                        HomeScreen(navController = navController, chatList = chatList)
                    }
                    composable(HomeRoute.ZoomImage.route) { backStackEntry ->
                        var imageId = backStackEntry.arguments?.getInt("imageId")
                        if (imageId == null) imageId = R.drawable.ic_launcher_background
                        ZoomPhoto(imageId = imageId) {
                            navController.popBackStack()
                        }
                    }
                    composable(HomeRoute.ChatDetail.route) {
                        DetailChat()
                    }

                    navigation(startDestination = ChatInfo.ProfileScreen.route, route = "info") {
                        composable(ChatInfo.ProfileScreen.route) {
                            ProfileScreen(
                                ChatId = "jfiodhg",
                                onMediaClick = { navController.navigate(ChatInfo.ChatMedia.route) },
                                onCallClick = { navController.navigate(Call.VoiceCall.route) },
                                onMediaVisibilityClick = { navController.navigate(ChatInfo.MediaVisibility.route) },
                                onBlockClick = { navController.navigate(ChatInfo.BlockUser.route) }
                            )
                        }
                        composable(ChatInfo.ChatMedia.route) {

                        }
                        composable(ChatInfo.MediaVisibility.route) {

                        }
                        composable(ChatInfo.BlockUser.route) {

                        }
                        composable(Call.VoiceCall.route) {

                        }
                    }

                }

                composable(MainRoute.Profile.route) {
                    StatusScreen(navController)
                }
                composable(MainRoute.Setting.route) {
                    SettingScreen(navController)
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("home", Icons.Default.Chat, "Home"),
        BottomNavItem("status", Icons.Default.Assessment, "Status"),
        BottomNavItem("call", Icons.Default.Call, "Calls")
    )

    BottomNavigation {
        val currentDestination = navController.currentBackStackEntryAsState()?.value?.destination
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentDestination?.route?.startsWith(item.route) == true,
                onClick = {
                    navController.navigate(item.route) {
                        // Avoid multiple copies of the same destination
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

data class BottomNavItem(val route: String, val icon: ImageVector, val label: String)

*/