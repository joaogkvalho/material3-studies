package com.example.material3.components.searchBar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarUI(
    modifier: Modifier = Modifier,
    query: String = "",
    placeholder: String = "",
    charLimit: Int = Int.MAX_VALUE,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit = {},
    active: Boolean = false,
    onItemClick: (String) -> Unit,
    onActiveChange: (Boolean) -> Unit
) {
    SearchBar(
        query = query,
        onQueryChange = {
            if (it.length <= charLimit) {
                onQueryChange(it)
            }
        },
        onSearch = { onSearch() },
        active = active,
        onActiveChange = onActiveChange,
        modifier = modifier,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.Gray
            )
        },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(
                    onClick = {
                        onQueryChange("")
                    },
                    content = {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    }
                )
            }
        },
        placeholder = {
            Text(
                text = placeholder,
                color = Color.Gray
            )
        },
        colors = SearchBarDefaults.colors(
            containerColor = Color(0xFFeff0f2),
            dividerColor = Color.Gray,
        ),
        content = {
            AnimatedVisibility(
                visible = active,
                content = {
                    LazyColumn(
                        contentPadding = PaddingValues(vertical = 32.dp)
                    ) {
                        items(20) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { onItemClick("Item ${it + 1}") }
                            ) {
                                Text(
                                    text = "Item ${it + 1}",
                                    modifier = Modifier
                                        .padding(horizontal = 16.dp)
                                )

                                if (it < 19) {
                                    HorizontalDivider(
                                        modifier = Modifier
                                            .padding(vertical = 32.dp),
                                        color = Color.Gray
                                    )
                                }
                            }
                        }
                    }
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchBarUIPreview() {
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
            onSearch = {},
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