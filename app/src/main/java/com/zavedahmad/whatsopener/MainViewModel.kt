package com.zavedahmad.whatsopener

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File

@Serializable
data class Country(val name: String, val dial_code: String, val code: String)

class MainViewModel : ViewModel() {
    val inputText = mutableStateListOf("")
    val searchText = mutableStateOf("")
    val countries = mutableListOf<Country>()
    val selectedCountry =mutableStateOf("+91")
    var showBottomSheet = mutableStateOf(false)
    val json = Json { ignoreUnknownKeys = true }


    init {

        try {

            val jsonString= CountriesData()
            val parsedCountries = json.decodeFromString<List<Country>>(jsonString)
            countries.addAll(parsedCountries)
        } catch (e: SerializationException) {
            // Handle parsing error (e.g., log it or set a default value)
            println("Error parsing JSON: ${e.message}")
        } catch (e: Exception) {
            // Handle other unexpected errors
            println("Unexpected error JSON: ${e.message}")
        }
    }

    fun getNumber(): String {
        return inputText[0]
    }
    fun getFilteredList(): List<Country>{
        return countries.filter{ it.name.contains(searchText.value, ignoreCase = true)}
    }
}