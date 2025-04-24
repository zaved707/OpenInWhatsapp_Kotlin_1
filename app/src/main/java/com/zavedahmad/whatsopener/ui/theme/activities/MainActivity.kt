package com.zavedahmad.whatsopener.ui.theme.activities

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zavedahmad.whatsopener.R
import com.zavedahmad.whatsopener.ui.theme.components.MainPage
import com.zavedahmad.whatsopener.ui.theme.viewModels.MainViewModel
import com.zavedahmad.whatsopener.ui.theme.WhatsOpenerTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContent {

            val viewModel: MainViewModel = viewModel()
            val uriHandler= LocalUriHandler.current
            WhatsOpenerTheme {
                Scaffold(topBar = {
                    TopAppBar(
                        colors = topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        ),
                        actions = {
                            IconButton(onClick = { uriHandler.openUri("http://www.github.com/zaved707/OpenInWhatsapp_Kotlin_1")}) {
                                Icon(
                                    painter = painterResource(id = R.drawable.github),
                                    contentDescription = "go to my github",
                                    modifier = Modifier.size(40.dp),
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        },
                        title = {
                            Text("WhatsOpener")
                        }
                    )
                }) { padding ->
                    Box(modifier = Modifier.padding(padding)) {
                        MainPage(viewModel, padding)
                    }
                }
            }
        }
    }
}