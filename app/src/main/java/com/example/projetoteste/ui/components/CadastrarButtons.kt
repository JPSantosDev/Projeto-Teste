package com.example.projetoteste.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.example.projetoteste.model.ModeloCurso

@Composable
fun CadastrarButtons(
    onCadastrar: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onCadastrar,
        modifier = modifier.fillMaxWidth()
    ) {
        Text("Cadastrar")
    }
}


