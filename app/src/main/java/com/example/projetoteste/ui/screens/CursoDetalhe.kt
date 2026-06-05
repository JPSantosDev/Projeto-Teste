package com.example.projetoteste.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetoteste.model.ModeloCurso
import com.example.projetoteste.ui.theme.ProjetoTesteTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CursoDetalhe(
    curso: ModeloCurso,
    onVoltar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Detalhe do curso") },
                navigationIcon = {
                    IconButton(onClick = onVoltar) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = curso.nomeCompleto,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = curso.nomeBreve,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFE50914)
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = "ID: ${curso.id}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Cyan
            )
            Text(
                text = "Categoria: ${curso.categoriaCurso}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Text(
                text = "Nível: ${curso.nivel.label}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Text(
                text = "Carga horária: ${curso.cargaHoraria}h",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Text(
                text = "Status: ${curso.status.label}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFE50914)
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = "Descrição",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = curso.descricaoCurta,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = curso.descricaoCompleta,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaDetalhe() {
    ProjetoTesteTheme {
        CursoDetalhe(
            curso = ModeloCurso().exemplos()[0],
            onVoltar = {}
        )
    }
}