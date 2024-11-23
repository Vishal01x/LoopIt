package com.exa.android.khacheri.utils

sealed class AuthRoute(val route : String){
    object Login : AuthRoute("login")
    object Register : AuthRoute("register")
    object ForgetPassword : AuthRoute("forget_password")
}

sealed class MainRoute(val route : String){
    object Home : MainRoute("home")
    object Profile : MainRoute("profile")
    object Setting : MainRoute("setting")
}


sealed class HomeRoute(val route : String){
    object ChatList : HomeRoute("chats_list")
    object ChatDetail : HomeRoute("chat_detail")
    object ZoomImage : HomeRoute("zoomImage/{imageId}") {
        fun createRoute(imageId: Int): String = "zoomImage/$imageId"
    }
}

sealed class ChatInfo(val route : String){
    object ProfileScreen : ChatInfo("profile")
    object ChatMedia : ChatInfo("media")
    object ProfileImage : ChatInfo("photo")
    object StarredMessage : ChatInfo("starred")
    object MediaVisibility : ChatInfo("visibility")
    object BlockUser : ChatInfo("block")
}

sealed class Call(val route : String){
    object VoiceCall : Call("voice")
    object VideoCall : Call("video")
}

sealed class NavigationCommand{
    object ToMainApp : NavigationCommand()
    object ToAuth : NavigationCommand()
}


