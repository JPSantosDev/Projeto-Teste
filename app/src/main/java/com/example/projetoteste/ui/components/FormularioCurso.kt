package com.example.projetoteste.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetoteste.ui.theme.ProjetoTesteTheme

@Composable
fun FormularioCurso(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Dados do Curso",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier.height(10.dp))

    }
}


@Preview (showBackground = true)
@Composable
fun PreviewFormularioCurso(){
    ProjetoTesteTheme() {
        FormularioCurso()
    }
}