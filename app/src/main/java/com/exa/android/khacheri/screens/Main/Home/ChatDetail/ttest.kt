package com.exa.android.khacheri.screens.Main.Home.ChatDetail
/*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exa.android.khacheri.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreenss() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        // Top Bar
        TopAppBar(
            title = { Text("Mengobrol", style = MaterialTheme.typography.titleLarge) },
            actions = {
                Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Black)
            },
//                backgroundColor = Color.White,
//                elevation = 0.dp
        )

        // Stories Section
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(storyList) { story ->
                StoryItem(image = story.image, name = story.name)
            }
        }

        // Chat List
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(chatList) { chat ->
                ChatItem(chat = chat)
            }
        }

        // Bottom Bar
        BottomAppBar(/*backgroundColor = Color.White, elevation = 8.dp*/) {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Home, contentDescription = "Home")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {},
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors( Color.Black)
            ) {
                Text("+ New Chat", color = Color.White, style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {}) {
                Icon(Icons.Default.Settings, contentDescription = "Settings")
            }
        }
    }
}

@Composable
fun StoryItem(image: Int, name: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(54.dp)
                .clip(CircleShape)
//                .border(2.dp, Color.LightGray, CircleShape)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            name,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun ChatItem(chat: Chat) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(chat.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(chat.name, style = MaterialTheme.typography.bodyLarge, color = Color.Black, fontWeight = FontWeight.Bold)
            Text(chat.lastMessage, style = MaterialTheme.typography.labelMedium, color = Color.DarkGray)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(chat.time, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
            if (chat.unreadCount > 0) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color.Yellow)
                ) {
                    Text(
                        "${chat.unreadCount}",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.Black
                    )
                }
            }
        }
    }
}


@Composable
fun HomeScreennew(modifier: Modifier = Modifier) {

}

@Composable
fun AddStoryButton() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(48.dp)
                .border(
                    width = 1.dp,
                    color = Color.Gray.copy(alpha = 0.5f),
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Story",
                tint = Color.Black,
                //modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "Add story",
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
        )
    }
}


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomNavigation(
    onHomeClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onNewChatClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Home Icon
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 16.dp)
                .clickable { onHomeClick() }
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                tint = Color.Black,
                modifier = Modifier.size(32.dp)
            )
        }

        // Central Button
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.Black, shape = RoundedCornerShape(50))
                .clickable { onNewChatClick() }
                .padding(horizontal = 24.dp, vertical = 8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "new chat",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 4.dp).size(22.dp)
                )
                Text(
                    text = "New Chat",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            }
        }

        // Profile Icon
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(end = 16.dp)
                .clickable { onProfileClick() }
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                tint = Color.Gray,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
fun CustomBottomNavigationBar(
    navController: NavController,
    onNewChatClick: () -> Unit
) {
    val currentDestination = navController.currentBackStackEntryAsState()?.value?.destination

    // Define navigation items
    val items = listOf(
        BottomNavItem(
            route = MainRoute.Home.route,
            icon = R.drawable.chat_ic,
            label = "Home",
            onClick = {
                navController.navigate(MainRoute.Home.route) {
                    launchSingleTop = true
                    restoreState = true
                }
            }
        ),
        BottomNavItem(
            route = MainRoute.Profile.route,
            icon = R.drawable.assesment_ic,
            label = "Profile",
            onClick = {
                navController.navigate(MainRoute.Profile.route) {
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    )

    // Render the custom navigation bar
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Render items dynamically
        items.forEach { item ->
            val isSelected = currentDestination?.route == item.route

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { item.onClick() }
            ) {
                Icon(
                    painter = painterResource(id = item.icon),
                    contentDescription = item.label,
                    tint = if (isSelected) Color.Black else Color.Gray,
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        // Central Button (always unselected but functional)
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.Black, shape = RoundedCornerShape(50))
                .clickable { onNewChatClick() }
                .padding(horizontal = 24.dp, vertical = 8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "New Chat",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .size(22.dp)
                )
                Text(
                    text = "New Chat",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewDashedCircle() {
    BottomNavigation(){
    }
}
*/