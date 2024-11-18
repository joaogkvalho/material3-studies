package com.example.material3.features.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.material3.components.searchBar.SearchBarUI

@Composable
fun SearchScreen() {
    var query by remember { mutableStateOf("") }
    var isActivated by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                if (!isActivated) {
                    16.dp
                } else {
                    0.dp
                }
            ),
    ) {
        SearchBarUI(
            query = query,
            placeholder = "Ex Avenida Paulista",
            onQueryChange = {
                query = it
            },
            onSearch = {
                isActivated = false
            },
            active = isActivated,
            onItemClick = {
                query = it
                isActivated = false
            },
            onActiveChange = {
                isActivated = !isActivated
            }
        )
    }
}