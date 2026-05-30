package com.example.projetoteste.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetoteste.ui.theme.ProjetoTesteTheme

@Composable
fun CadastrarButtons(
    modifier: Modifier = Modifier,
    onLimpar: () -> Unit,
    onValidar: () -> Unit,
    onCarregarExemplo: () -> Unit,
    onCadastrar: () -> Unit = {}

) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = onLimpar,
                modifier = Modifier.weight(1f)
            ) {
                Text("Limpar")
            }
            OutlinedButton(
                onClick = onCarregarExemplo,
                modifier = Modifier.weight(1f)
            ) {
                Text("Carregar exemplo")
            }
        }

        Spacer(Modifier.height(8.dp))

        // Botão principal de validação
        Button(
            onClick = onValidar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Validar cadastro")
        }

        Spacer(Modifier.height(4.dp))

        // Botão de salvar curso
        Button(
            onClick = onCadastrar,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B5E20))
        ) {
            Text("Cadastrar")
        }
    }
}

@Preview(showBackground = true, name = "Botões de ação")
@Composable
fun PreviewCadastrarButtons() {
    ProjetoTesteTheme {
        CadastrarButtons(
            onLimpar = {},
            onValidar = {},
            onCarregarExemplo = {},
            onCadastrar = {}
        )
    }
}