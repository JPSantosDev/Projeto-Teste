package com.example.projetoteste.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetoteste.model.ModeloCurso
import com.example.projetoteste.ui.components.Cabecalho
import com.example.projetoteste.ui.components.ContainerImage
import com.example.projetoteste.ui.components.FormularioCurso

@Preview
@Composable
fun FullApplication(
    modifier: Modifier = Modifier

) {
    var curso by remember { mutableStateOf(ModeloCurso()) }
    var status by remember { mutableStateOf("Preencha os dados para gerar a visualização do curso.") }
    val scrollState = rememberScrollState()

    Scaffold( // Scaffold cria a estrutura base da tela Material 3, respeitando barras do sistema.
        modifier = modifier.fillMaxSize(), // A tela ocupa toda a área disponível da Activity.
        containerColor = MaterialTheme.colorScheme.background // Aplica a cor de fundo definida no tema.
    ) { innerPadding ->
        Column( // Column organiza cabeçalho, imagem, formulário, ações, status e prévia em fluxo vertical.
            modifier = Modifier // Inicia a cadeia de modificadores do conteúdo principal.
                .fillMaxSize() // Faz o conteúdo ocupar toda a área disponível dentro do Scaffold.
                .padding(innerPadding) // Respeita barras do sistema e áreas internas calculadas pelo Scaffold.
                .padding(
                    horizontal = 20.dp,
                    vertical = 16.dp
                ) // Adiciona margens visuais confortáveis em modo retrato.
                .verticalScroll(scrollState)
        ) {
            Cabecalho()
            ContainerImage()
            FormularioCurso(
                curso = curso,
                onNomeCompletoChange = { novoValor ->
                    curso = curso.copy(nomeCompleto = novoValor)
                },
                onNomeBreveChange = { novoValor -> curso = curso.copy(nomeBreve = novoValor) },
                onCategoriaChange = { novoValor -> curso = curso.copy(categoriaCurso = novoValor) },
                onCargaHorariaChange = { novoValor ->
                    curso = curso.copy(cargaHoraria = novoValor)
                },
                onDescricaoChange = { novoValor -> curso = curso.copy(descricaoCurta = novoValor) }
            )
        }
    }
}