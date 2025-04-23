package com.zavedahmad.whatsopener

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    val inputText= mutableStateListOf("")

    fun getNumber  () : String{
        return inputText[0]
    }
}