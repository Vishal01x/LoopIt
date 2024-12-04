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

@Composable
fun ChatHeader(onBack: () -> Unit, onProfileClick: () -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
//            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "back to ChatList",
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onBack() }
            )
            Row(modifier = Modifier
                .clickable { onProfileClick() }
                .padding(vertical = 8.dp))
            {
                Image(
                    painter = painterResource(id = R.drawable.chat_img1),
                    contentDescription = "profile",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(
                        text = "Andrew Joe",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

//                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "last seen at 10:45",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.Gray
                    )
                }
            }

//            Card(modifier = Modifier
//                .clip(CircleShape)
//                .size(40.dp)
//                .padding(2.dp),
//                elevation = CardDefaults.cardElevation(12.dp),
//                shape = CardDefaults.outlinedShape,
//                colors = CardDefaults.cardColors(Color.White)){
//
//            }
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "call user",
                tint = Color.Black
            )

            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "call user",
                tint = Color.Black
            )
        }
    }
}




import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.app.ComponentActivity
import com.exa.android.khacheri.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.random.Random


@Composable
fun AnimatedSoundWave(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val wavePhase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Canvas(modifier = modifier
        .fillMaxWidth()
        .height(30.dp)) {
        val waveWidth = size.width / 20
        val waveHeight = size.height / 2
        val centerY = size.height / 2

        for (i in 0..20) {
            val offsetX = waveWidth * i
            val offsetY = waveHeight * kotlin.math.sin(2 * Math.PI * (i + wavePhase) / 10).toFloat()

            drawLine(
                color = Color.Green,
                start = Offset(offsetX, centerY - offsetY),
                end = Offset(offsetX, centerY + offsetY),
                strokeWidth = 6f
            )
        }
    }
}

@Composable
fun WhatsAppStyleWave(
    modifier: Modifier = Modifier,
    isPaused: Boolean
) {
    val infiniteTransition = rememberInfiniteTransition()
    val amplitudeAnimation by infiniteTransition.animateFloat(
        initialValue = 0.1f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val waveAmplitudes = remember {
        List(10) { Random.nextFloat() } // Mock random wave amplitudes
    }

    Canvas(modifier = modifier
        .fillMaxWidth()
        .height(40.dp)) {
        val waveWidth = size.width / waveAmplitudes.size
        val centerY = size.height / 2

        waveAmplitudes.forEachIndexed { index, amplitude ->
            val barHeight = if (isPaused) 0f else centerY * amplitude * amplitudeAnimation
            drawRoundRect(
                color = Color.Gray,
                topLeft = Offset(
                    x = index * waveWidth + waveWidth / 4,
                    y = centerY - barHeight / 2
                ),
                size = Size(waveWidth / 2, barHeight),
                cornerRadius = CornerRadius(x = 4.dp.toPx(), y = 4.dp.toPx())
            )
        }
    }
}

@Composable
fun DynamicWaveform(
    modifier: Modifier = Modifier,
    audioAmplitudes: List<Float>
) {
    val maxAmplitude = 32767f // Maximum amplitude for 16-bit PCM audio

    Canvas(modifier = modifier) {
        val centerY = size.height / 2
        val widthPerSample = size.width / audioAmplitudes.size

        val path = Path()
        audioAmplitudes.forEachIndexed { index, amplitude ->
            val normalizedAmplitude = (amplitude / maxAmplitude) * size.height / 2
            val x = index * widthPerSample
            val y = centerY - normalizedAmplitude
            if (index == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }
        }

        drawPath(
            path = path,
            color = Color.Green,
            style = Stroke(width = 2.dp.toPx(), cap = StrokeCap.Round)
        )
    }
}

@Composable
fun SendTFMessage(
    onSendClick: (String) -> Unit,
    onAddClick: () -> Unit,
    onMicClick: () -> Unit
) {
    var message by remember { mutableStateOf("") }
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Add Button
            IconButton(onClick = onAddClick) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Text Field
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0xFFEFEFEF)) // Light grey background
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (message.isEmpty()) {
                    Text(
                        text = "Type a Message",
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                BasicTextField(
                    value = message,
                    onValueChange = { message = it },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
                    maxLines = 4
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Microphone or Send Button
            IconButton(
                onClick = {
                    if (message.isNotEmpty()) {
                        onSendClick(message)
                        message = ""
                    } else {
                        onMicClick()
                    }
                }
            ) {
                Icon(
                    painter = painterResource(if (message.isEmpty()) R.drawable.microphone else R.drawable.send),
                    contentDescription = "Send or Mic",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun SendAudioMessage(
//    isRecording: Boolean = true,
    isPaused: Boolean,
    recordingTime: String,
    onDeleteRecording: () -> Unit,
    onPauseResumeRecording: () -> Unit,
    onSendRecording: () -> Unit
) {

    /* var audioAmplitudes by remember { mutableStateOf<List<Float>>(emptyList()) }
        val scope = rememberCoroutineScope()
        val context = LocalContext.current

       // Check Microphone Permission
        val hasMicPermission = remember {
            ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.RECORD_AUDIO
            ) == PackageManager.PERMISSION_GRANTED
        }

        // Start recording when `isRecording` becomes true
        LaunchedEffect(isRecording) {
            if (isRecording && hasMicPermission) {
                scope.launch(Dispatchers.IO) {
                    val bufferSize = AudioRecord.getMinBufferSize(
                        44100, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT
                    )
                    val audioRecord = AudioRecord(
                        MediaRecorder.AudioSource.MIC,
                        44100,
                        AudioFormat.CHANNEL_IN_MONO,
                        AudioFormat.ENCODING_PCM_16BIT,
                        bufferSize
                    )

                    val buffer = ShortArray(bufferSize)
                    audioRecord.startRecording()

                    try {
                        while (isRecording) {
                            val read = audioRecord.read(buffer, 0, buffer.size)
                            if (read > 0) {
                                val amplitudes = buffer.take(read).map { abs(it.toFloat()) }
                                audioAmplitudes = amplitudes
                            }
                        }
                    } finally {
                        audioRecord.stop()
                        audioRecord.release()
                    }
                }
            } else {
                audioAmplitudes = emptyList() // Clear waveform when not recording
            }
        }

    //    if (!hasMicPermission) {
    //        RequestMicrophonePermission()
    //    }*/
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Delete Button
            IconButton(onClick = onDeleteRecording) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Recording",
                    tint = Color.Black
                )
            }

            // Timer
            Text(
                text = recordingTime,
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(100.dp)
//                .padding(horizontal = 16.dp, vertical = 8.dp)
//        ) {
//            DynamicWaveform(
//                modifier = Modifier.fillMaxSize(),
//                audioAmplitudes = audioAmplitudes
//            )
//        }

            // Sound Wave Animation
            if (!isPaused) {
                WhatsAppStyleWave(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    isPaused = isPaused
                )
            } else {
                Divider(
                    modifier = Modifier
                        .weight(1f)
                        .height(2.dp)
                        .background(Color.Gray)
                )
            }
            // Pause/Resume Button
            IconButton(onClick = onPauseResumeRecording) {
                Icon(
                    painter = painterResource(if (isPaused) R.drawable.play else R.drawable.pause),
                    contentDescription = "Pause/Resume Recording",
                    tint = Color.Black
                )
            }

            // Send Button
            IconButton(onClick = onSendRecording) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send Recording",
                    tint = Color.Black
                )
            }
        }
    }
}

@Composable
fun NewMessageSection(
    modifier: Modifier = Modifier,
    onTextMessageSend: (String) -> Unit,
    onRecordingSend: () -> Unit,
    onAddClick: () -> Unit
) {
    var isRecording by remember { mutableStateOf(false) }
    var isPaused by remember { mutableStateOf(false) }
    var recordingTime by remember { mutableStateOf("00:00") }
    var elapsedSeconds by remember { mutableStateOf(0) } // Tracks total elapsed seconds
    var timerJob by remember { mutableStateOf<Job?>(null) }

    fun startTimer() {
        timerJob?.cancel()
        timerJob = CoroutineScope(Dispatchers.IO).launch {
            while (isActive) {
                delay(1000L)
                elapsedSeconds++
                recordingTime = String.format("%02d:%02d", elapsedSeconds / 60, elapsedSeconds % 60)
            }
        }
    }

    fun pauseTimer() {
        timerJob?.cancel()
    }

    fun resetTimer() {
        isRecording = false
        isPaused = false
        recordingTime = "00:00"
        elapsedSeconds = 0
        timerJob?.cancel()
    }

    // Timer logic
    LaunchedEffect(isRecording, isPaused) {
        if (isRecording) {
            if (!isPaused) {
                startTimer()
            } else {
                pauseTimer()
            }
        } else {
            resetTimer()
        }
    }

    if (!isRecording) {
        // Text Input UI
        SendTFMessage(
            onSendClick = { message -> onTextMessageSend(message) },
            onAddClick = onAddClick,
            onMicClick = { isRecording = true }
        )
    } else {
        // Audio Recording UI
        SendAudioMessage(
            isPaused = isPaused,
            recordingTime = recordingTime,
            onDeleteRecording = {
                resetTimer()
            },
            onPauseResumeRecording = {
                isPaused = !isPaused
            },
            onSendRecording = {
                onRecordingSend()
                resetTimer()
            }
        )
    }
}

@Composable
fun RequestMicrophonePermission() {
    val context = LocalContext.current
    val activity = LocalContext.current as? ComponentActivity

    SideEffect {
        ActivityCompat.requestPermissions(
            activity ?: return@SideEffect,
            arrayOf(Manifest.permission.RECORD_AUDIO),
            1234 // Request code (can be any unique value)
        )
    }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Microphone permission required to record audio.")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDashedCircle() {
    NewMessageSection(
        onTextMessageSend = {},
        onRecordingSend = {},
        onAddClick = {}
    )
}



@Composable
fun ChatListScreen(
    userId: String, // Current user's ID
    viewModel: ChatViewModel, // ViewModel instance
    onUserSelected: (String) -> Unit // Callback when a user is selected
) {
    val chatList by viewModel.chats.observeAsState(emptyList())

    LaunchedEffect(userId) {
        viewModel.fetchChats(userId)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Chats") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(chatList) { chat ->
                ChatListItem(
                    chat = chat,
                    currentUserId = userId,
                    onClick = { onUserSelected(it) }
                )
            }
        }
    }
}

@Composable
fun ChatListItem(
    chat: Chat,
    currentUserId: String,
    onClick: (String) -> Unit
) {
    val otherUserId = chat.users.first { it != currentUserId } // Find the other user in the chat
    val userProfile = remember { mutableStateOf<User?>(null) }

    // Fetch user profile information for the other user
    LaunchedEffect(otherUserId) {
        val user = fetchUserProfile(otherUserId) // Function to fetch the user profile
        userProfile.value = user
    }

    userProfile.value?.let { user ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick(otherUserId) }
                .padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(user.profilePicUrl),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = chat.lastMessage,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Text(
                text = formatTimestamp(chat.lastMessageTimestamp), // Format the timestamp for display
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}

fun formatTimestamp(timestamp: Timestamp?): String {
    return timestamp?.toDate()?.let {
        DateFormat.getTimeInstance(DateFormat.SHORT).format(it)
    } ?: ""
}

suspend fun fetchUserProfile(userId: String): User {
    val firestore = FirebaseFirestore.getInstance()
    val userSnapshot = firestore.collection("users").document(userId).get().await()
    return userSnapshot.toObject<User>()!!
}



@Composable
fun ChatListScreen(
    userId: String,
    onUserSelected: (String) -> Unit
) {
    val viewModel : ChatViewModel =  hiltViewModel()
    val chatList by viewModel.chats.observeAsState(emptyList())

    LaunchedEffect(userId) {
        viewModel.fetchChats(userId)
    }

    Scaffold{ paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(chatList) { chat ->
                ChatListItem(
                    chat = chat,
                    currentUserId = userId,
                    onClick = { onUserSelected(it) },
                    fetchUserProfile = { id -> viewModel.fetchUserProfile(id) }
                )
            }
        }
    }
}

@Composable
fun ChatListItem(
    chat: Chat,
    currentUserId: String,
    onClick: (String) -> Unit,
    fetchUserProfile: (String) -> User?
) {
    val otherUserId = chat.users.first { it != currentUserId }
    val userProfile = produceState<User?>(null, otherUserId) {
        value = fetchUserProfile(otherUserId)
    }

    userProfile.value?.let { user ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick(otherUserId) }
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.chat_img3),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = chat.lastMessage,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Text(
                text = formatTimestamp(chat.lastMessageTimestamp),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}

fun formatTimestamp(timestamp: Timestamp?): String {
    return timestamp?.toDate()?.let {
        DateFormat.getTimeInstance(DateFormat.SHORT).format(it)
    } ?: ""
}

@Composable
fun UserChatsList(viewModel: ChatViewModel) {
    val userChats by viewModel.userChats.observeAsState(listOf())

    LazyColumn {
        items(userChats) { chat ->
            Text("Chat with ${chat.users.joinToString(", ")}")
            // Navigate to the chat screen with this chat data
        }
    }
}


//@Composable
//fun ChatMessages(viewModel: ChatViewModel, chatId: String) {
//    val messages by viewModel.chatMessages.observeAsState(listOf())
//
//    LazyColumn {
//        items(messages) { message ->
//            Text(message.message)
//            // Display message status and sender's info
//        }
//    }
//
//    // Fetch messages for the current chat when the screen is loaded
//    LaunchedEffect(chatId) {
//        viewModel.fetchChatMessages(chatId)
//    }
//}



@HiltViewModel
class ChatViewModel @Inject constructor(
    private val firestoreRepository: FirestoreRepository
) : ViewModel() {

    private val _userChats = MutableLiveData<List<Chat>>()
    val userChats: LiveData<List<Chat>> get() = _userChats

    private val _chatMessages = MutableLiveData<List<Message>>()
    val chatMessages: LiveData<List<Message>> get() = _chatMessages

    // Fetch user chats from Firestore
    fun fetchUserChats(userId: String) {
        firestoreRepository.getUserChats(userId)
            .addOnSuccessListener { querySnapshot ->
                val chats = querySnapshot.documents.map { document ->
                    document.toObject(Chat::class.java)!!
                }
                _userChats.value = chats
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error fetching chats", e)
            }
    }

    // Fetch chat messages from Firestore
    fun fetchChatMessages(chatId: String) {
        firestoreRepository.getChatMessages(chatId)
            .orderBy("timestamp")
            .get()
            .addOnSuccessListener { querySnapshot ->
                val messages = querySnapshot.documents.map { document ->
                    document.toObject(Message::class.java)!!
                }
                _chatMessages.value = messages
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error fetching messages", e)
            }
    }

    // Send a message in the chat
    suspend fun sendMessage(chatId: String, message: Message) {
        val messageId = firestoreRepository.getChatMessages(chatId).document().id
        firestoreRepository.sendMessage(chatId, messageId, message)
    }
}



@Singleton
class FirestoreRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    private val usersCollection = firestore.collection("users")
    private val chatsCollection = firestore.collection("chats")

    // Insert a new user
    suspend fun insertUser(userId: String, user: User) {
        usersCollection.document(userId).set(user)
            .addOnSuccessListener { Log.d("Firestore", "User added successfully") }
            .addOnFailureListener { e -> Log.w("Firestore", "Error adding user", e) }
    }

    // Fetch a user by ID
    fun getUserById(userId: String): Task<DocumentSnapshot> {
        return usersCollection.document(userId).get()
    }

    // Create a new chat
    suspend fun createChat(chatId: String, chat: Chat) {
        chatsCollection.document(chatId).set(chat)
            .addOnSuccessListener { Log.d("Firestore", "Chat created successfully") }
            .addOnFailureListener { e -> Log.w("Firestore", "Error creating chat", e) }
    }

    // Insert a new message in the chat
    suspend fun sendMessage(chatId: String, messageId: String, message: Message) {
        val messageRef = chatsCollection.document(chatId).collection("messages").document(messageId)
        messageRef.set(message)
            .addOnSuccessListener { Log.d("Firestore", "Message sent successfully") }
            .addOnFailureListener { e -> Log.w("Firestore", "Error sending message", e) }

        // Update the last message and timestamp in the chat metadata
        val chatRef = chatsCollection.document(chatId)
        chatRef.update(
            "lastMessage", message.message,
            "lastMessageTimestamp", message.timestamp
        )
    }

    // Fetch chats for a particular user
    fun getUserChats(userId: String): Task<QuerySnapshot> {
        return chatsCollection.whereArrayContains("users", userId).get()
    }

    // Fetch messages for a particular chat
    fun getChatMessages(chatId: String): CollectionReference {
        return chatsCollection.document(chatId).collection("messages")
    }
}


*/


import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.exa.android.khacheri.utils.createImageFile
import com.google.firebase.BuildConfig
import java.util.*


@Composable
fun AppContent() {

    val context = LocalContext.current
    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        BuildConfig.LIBRARY_PACKAGE_NAME + ".provider", file
    )

    var capturedImageUri by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }

    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
            capturedImageUri = uri
        }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            cameraLauncher.launch(uri)
        } else {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            val permissionCheckResult =
                ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
            if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                cameraLauncher.launch(uri)
            } else {
                // Request a permission
                permissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }) {
            Text(text = "Capture Image From Camera")
        }
    }

    if (capturedImageUri.path?.isNotEmpty() == true) {
        Image(
            modifier = Modifier
                .padding(16.dp, 8.dp),
            painter = rememberAsyncImagePainter(capturedImageUri),
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun show(){
    AppContent()
}
