package com.example.projetoteste.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Busca(
    textValue: String,
    mudarTexto: (String) -> Unit
){
    OutlinedTextField(
        placeholder = {Text(text = "Busca")},
        value = textValue,
        onValueChange = mudarTexto,
        singleLine = true
    )
}

@Composable
@Preview (showBackground = true)
fun PreviewBusca(){
    Busca(
        textValue = "",
        mudarTexto = {}
    )
}