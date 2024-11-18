package com.example.material3.features.feed

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.material3.components.dialog.CommonDialog
import com.example.material3.components.menu.MenuUI
import com.example.material3.components.sheets.BottomSheetUI
import com.example.material3.components.textField.DefaultOutlinedTextField
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    navigateToDrawerScreen: () -> Unit
) {
    val scope = rememberCoroutineScope()

    // TextField
    var textValue by remember {
        mutableStateOf("")
    }

    // SnackBar
    val snackbarHostState = remember { SnackbarHostState() }

    // BottomSheet
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { true }
    )
    var showBottomSheet by remember { mutableStateOf(false) }

    // Dialog
    var openAlertDialog by remember { mutableStateOf(false) }

    //TopAppBar
    var expanded by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TopAppBar(
                    title = { Text(text = "Feed") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFFd9fdd3)
                    ),
                    actions = {
                        IconButton(
                            onClick = { expanded = true },
                            content = {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = null
                                )
                            }
                        )
                    }
                )

                HorizontalDivider(
                    color = Color(0xFF16603e).copy(alpha = 0.2f)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.TopEnd),
                ) {
                    MenuUI(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        },
                        onEditClick = {
                            expanded = false
                        },
                        onSettingsClick = {
                            expanded = false
                        },
                        onSendEmailClick = {
                            expanded = false
                        }
                    )
                }
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        containerColor = Color(0XFFd9fdd3),
        content = { contentPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("FeedScreen")

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        openAlertDialog = true
                    },
                    content = {
                        Text("Abrir dialog")
                    }
                )

                Button(
                    onClick = {
                        scope.launch {
                            val result = snackbarHostState
                                .showSnackbar(
                                    message = "Aqui a gente passa a nossa mensagem",
                                    actionLabel = "Confirmar",
                                    duration = SnackbarDuration.Short
                                )
                            when (result) {
                                SnackbarResult.ActionPerformed -> {
                                    Log.i("INFOTESTE", "ActionPerformed")
                                }
                                SnackbarResult.Dismissed -> {
                                    Log.i("INFOTESTE", "Dismissed")
                                }
                            }
                        }
                    },
                    content = {
                        Text("Abrir snackBar")
                    }
                )

                Button(
                    onClick = navigateToDrawerScreen,
                    content = {
                        Text("Navigation Drawer")
                    }
                )

                Button(
                    onClick = {
                        showBottomSheet = true
                    },
                    content = {
                        Text("BottomSheet")
                    }
                )

                DefaultOutlinedTextField(
                    modifier = Modifier
                        .padding(32.dp),
                    value = textValue,
                    label = "Nome",
                    placeholder = "Ex: João Gabriel",
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        imeAction = ImeAction.Next
                    ),
                    charLimit = 30,
                    onValueChange = {
                        textValue = it
                    }
                )

                if (openAlertDialog) {
                    CommonDialog(
                        dialogTitle = "Atenção",
                        dialogText = "Estamos aprendendo sobre o Material3",
                        icon = Icons.Default.Warning,
                        onConfirmation = {},
                        onDismissRequest = {
                            openAlertDialog = false
                        }
                    )
                }
            }

            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState,
                    dragHandle = {
                        BottomSheetDefaults.DragHandle(
                            width = 38.dp,
                            height = 3.dp,
                            color = Color(0xFFE0E0E0)
                        )
                    },
                    content = {
                        BottomSheetUI(
                            onDismiss = {
                                scope.launch { sheetState.hide() }.invokeOnCompletion {
                                    if (!sheetState.isVisible) {
                                        showBottomSheet = false
                                    }
                                }
                            }
                        )
                    }
                )
            }
        },
    )
}

@Preview
@Composable
private fun FeedScreenPreview() {
    FeedScreen(
        navigateToDrawerScreen = {}
    )
}