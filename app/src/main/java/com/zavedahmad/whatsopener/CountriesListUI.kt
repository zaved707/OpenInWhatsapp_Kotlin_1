package com.zavedahmad.whatsopener

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CountriesListUI(viewModel: MainViewModel) {
    LazyColumn(

    ) {
        itemsIndexed(
            items = viewModel.countries,
            key = { index, country -> country.code }) { index, country ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = { viewModel.selectedCountry.value = country.dial_code
                    viewModel.showBottomSheet.value=false})
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(0.7f),
                    text = country.name, // Example: Use index for numbering
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = country.dial_code,
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }

    }


}