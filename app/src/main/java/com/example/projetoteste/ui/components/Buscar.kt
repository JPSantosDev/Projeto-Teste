package com.example.projetoteste.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Busca(
    textValue: String,
    mudarTexto: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        placeholder = { Text(text = "Busca") },
        value = textValue,
        onValueChange = mudarTexto,
        singleLine = true,
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewBusca() {
    Busca(
        textValue = "",
        mudarTexto = {}
    )
}