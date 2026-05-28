package com.example.projetoteste.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.projetoteste.ui.theme.ProjetoTesteTheme

@Composable
fun CabecalhoCadastro(
modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = "Cadastro Visual de Cursos",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = "Monte a apresentação inicial de um curso técnico."
        )
    }

}


@Preview (showBackground = true)
@Composable
private fun CabecalhoCadastroPreview(){
    ProjetoTesteTheme{
CabecalhoCadastro()
    }
}