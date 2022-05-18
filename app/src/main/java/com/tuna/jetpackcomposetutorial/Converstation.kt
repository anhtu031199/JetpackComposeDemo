package com.tuna.jetpackcomposetutorial

import android.R
import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.tuna.jetpackcomposetutorial.messsage.Message
import com.tuna.jetpackcomposetutorial.messsage.MessageCardScreen
import com.tuna.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

@Composable
fun Conversation(
    navController: NavController
) {
    val message = remember {
        SampleData.conversationSample
    }

    ConversationScreen(
        messages = message,
        onNavigateToHome = {
            navController.navigate("test")
        },
    )
}

@Composable
fun ConversationScreen(
    messages: List<Message>,
    onNavigateToHome: (() -> Unit)? = null,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Home Screen")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onNavigateToHome?.invoke()
                        },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_input_add),
                            contentDescription = "",
                        )
                    }
                }
            )
        }
    ) {
        LazyColumn {
            items(messages) { message ->
                MessageCardScreen(message, "hello world")
            }
        }
    }
}

@Preview(name = "LightMode", showBackground = true)
@Preview(
    name = "DarkMode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewConversation() {
    JetpackComposeTutorialTheme {
        ConversationScreen(SampleData.conversationSample)
    }
}
