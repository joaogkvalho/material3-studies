package com.example.material3.components.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MenuUI(
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    onDismissRequest: () -> Unit,
    onEditClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onSendEmailClick: () -> Unit

) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        content = {
            DropdownMenuItem(
                text = {
                    Text(
                        text = "Editar",
                        color = Color(0xFF16603e)
                    )
                },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = null,
                        tint = Color(0xFF16603e)
                    )
                },
                onClick = onEditClick
            )
            DropdownMenuItem(
                text = {
                    Text(
                        text = "Configurações",
                        color = Color(0xFF16603e)
                    )
                },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Settings,
                        contentDescription = null,
                        tint = Color(0xFF16603e)
                    )
                },
                onClick = onSettingsClick
            )
            DropdownMenuItem(
                text = {
                    Text(
                        text = "Enviar e-mail",
                        color = Color(0xFF16603e)
                    )
                },
                leadingIcon = {
                    Icon(
                        Icons.AutoMirrored.Outlined.Send,
                        contentDescription = null,
                        tint = Color(0xFF16603e)
                    )
                },
                trailingIcon = {
                    Text(
                        text = "F11",
                        color = Color(0xFF16603e)
                    )
                },
                onClick = onSendEmailClick
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun MenuUIPreview() {
    MenuUI(
        expanded = false,
        onDismissRequest = {},
        onEditClick = {},
        onSettingsClick = {},
        onSendEmailClick = {}
    )
}