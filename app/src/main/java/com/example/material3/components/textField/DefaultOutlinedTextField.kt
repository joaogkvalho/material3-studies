package com.example.material3.components.textField

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DefaultOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    label: String = "",
    placeholder: String = "",
    charLimit: Int = Int.MAX_VALUE,
    enabled: Boolean = true,
    isError: Boolean = false,
    singleLine: Boolean = false,
    requireKeyboardFocus: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit
) {
    val focusRequester = remember { FocusRequester() }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                if (it.length <= charLimit) {
                    onValueChange(it)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            enabled = enabled,
            label = {
                Text(text = label)
            },
            supportingText = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Limit: ${value.length}/$charLimit",
                    textAlign = TextAlign.End
                )
            },
            placeholder = {
                Text(text = placeholder)
            },
            leadingIcon = {
               Icon(
                   imageVector = Icons.Default.Person,
                   contentDescription = null
               )
            },
            trailingIcon = {
                if (value.isNotEmpty()) {
                    IconButton(
                        onClick = {
                            onValueChange("")
                        },
                        content = {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null
                            )
                        }
                    )
                }
            },
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            singleLine = singleLine,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Gray,
                focusedBorderColor = Color(0xFF16603e),
                disabledBorderColor = Color.Gray.copy(0.5f),
                errorBorderColor = Color.Red.copy(0.5f),
                unfocusedLabelColor = Color.Gray,
                focusedLabelColor = Color(0xFF16603e),
                disabledLabelColor = Color.Gray.copy(0.5f),
                errorLabelColor = Color.Red.copy(0.5f),
                unfocusedLeadingIconColor = Color.Gray,
                focusedLeadingIconColor = Color(0xFF16603e),
                disabledLeadingIconColor = Color.Gray.copy(0.5f),
                errorLeadingIconColor = Color.Red.copy(0.5f)
            )
        )

        if (requireKeyboardFocus) {
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultOutlinedTextFieldPreview() {
    var textValue by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultOutlinedTextField(
            modifier = Modifier
                .padding(32.dp),
            value = textValue,
            label = "Nome",
            placeholder = "Ex: João Gabriel",
            onValueChange = {
                textValue = it
            }
        )
    }
}