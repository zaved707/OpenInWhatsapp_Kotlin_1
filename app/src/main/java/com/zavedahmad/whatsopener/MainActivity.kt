package com.zavedahmad.whatsopener

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel


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
