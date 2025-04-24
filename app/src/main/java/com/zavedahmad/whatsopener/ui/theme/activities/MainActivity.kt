package com.zavedahmad.whatsopener.ui.theme.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zavedahmad.whatsopener.ui.theme.components.MainPage
import com.zavedahmad.whatsopener.ui.theme.viewModels.MainViewModel
import com.zavedahmad.whatsopener.ui.theme.WhatsOpenerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

//        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContent {
            val viewModel: MainViewModel = viewModel()
            WhatsOpenerTheme {
                MainPage(viewModel)
            }
        }
    }
}