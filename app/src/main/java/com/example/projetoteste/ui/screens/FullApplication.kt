package com.example.projetoteste.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetoteste.model.ModeloCurso
import com.example.projetoteste.ui.components.CadastrarButtons
import com.example.projetoteste.ui.components.Cabecalho
import com.example.projetoteste.ui.components.ContainerImage
import com.example.projetoteste.ui.components.CursoCard
import com.example.projetoteste.ui.components.FormularioCurso
import com.example.projetoteste.ui.theme.ProjetoTesteTheme
import com.example.projetoteste.utils.CursoValidator

@Preview
@Composable
fun FullApplication(modifier: Modifier = Modifier) {
    // Começa na aba 1 (Cadastrar Curso)
    var selectedTab by remember { mutableIntStateOf(1) }
    var curso by remember { mutableStateOf(ModeloCurso()) }
    var cursos by remember { mutableStateOf(listOf<ModeloCurso>()) }
    var statusMessage by remember {
        mutableStateOf("Preencha os dados para gerar a visualização do curso.")
    }
    var erros by remember { mutableStateOf<List<String>>(emptyList()) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF1A1A1A)) {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Meus Cursos") },
                    label = { Text("Meus Cursos") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFFE50914),
                        selectedTextColor = Color(0xFFE50914),
                        unselectedIconColor = Color.Gray,
                        unselectedTextColor = Color.Gray,
                        indicatorColor = Color(0xFF2A2A2A)
                    )
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Icon(Icons.Default.Add, contentDescription = "Cadastrar Curso") },
                    label = { Text("Cadastrar Curso") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFFE50914),
                        selectedTextColor = Color(0xFFE50914),
                        unselectedIconColor = Color.Gray,
                        unselectedTextColor = Color.Gray,
                        indicatorColor = Color(0xFF2A2A2A)
                    )
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Cabecalho()

            when (selectedTab) {
                0 -> {
                    if (cursos.isEmpty()) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Nenhum curso cadastrado ainda.", color = Color.Gray)
                        }
                    } else {
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(cursos) { item ->
                                CursoCard(curso = item)
                                Spacer(Modifier.height(16.dp))
                            }
                        }
                    }
                }

                1 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                    ) {
                        Spacer(Modifier.height(8.dp))

                        ContainerImage()

                        Spacer(Modifier.height(16.dp))
                        Text(
                            text = "Cadastro Visual de Cursos",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = "Monte a apresentação inicial de um curso técnico.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )

                        Spacer(Modifier.height(16.dp))

                        FormularioCurso(
                            curso = curso,
                            onNomeCompletoChange = { curso = curso.copy(nomeCompleto = it) },
                            onNomeBreveChange = { curso = curso.copy(nomeBreve = it) },
                            onCategoriaChange = { curso = curso.copy(categoriaCurso = it) },
                            onCargaHorariaChange = { curso = curso.copy(cargaHoraria = it) },
                            onDescricaoChange = { curso = curso.copy(descricaoCurta = it) }
                        )

                        Spacer(Modifier.height(16.dp))
                        Card(modifier = Modifier.fillMaxWidth()) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = "Pré-visualização do curso",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = curso.nomeBreve.ifEmpty { "Nome breve não informado" },
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xFFE50914)
                                )
                                Text(
                                    text = curso.nomeCompleto.ifEmpty { "Nome completo não informado" },
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = curso.categoriaCurso.ifEmpty { "Categoria pendente" },
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.Gray
                                )
                                Text(
                                    text = if (curso.cargaHoraria.isEmpty())
                                        "Carga horária pendente"
                                    else
                                        "Carga horária: ${curso.cargaHoraria}h",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.Gray
                                )
                                Text(
                                    text = curso.descricaoCurta.ifEmpty { "Descrição ainda não preenchida" },
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.Gray
                                )
                            }
                        }

                        Spacer(Modifier.height(12.dp))

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))
                        ) {
                            Text(
                                text = statusMessage,
                                modifier = Modifier.padding(12.dp),
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.LightGray
                            )
                        }

                        Spacer(Modifier.height(12.dp))
                        CadastrarButtons(
                            onLimpar = {
                                curso = ModeloCurso()
                                erros = emptyList()
                                statusMessage = "Formulário limpo."
                            },
                            onValidar = {
                                val resultado = CursoValidator.validar(curso)
                                erros = resultado.mensagens
                                statusMessage = when {
                                    resultado.valido ->
                                        "Cadastro visual válido para apresentação."
                                    resultado.mensagens.size > 1 ->
                                        "Há múltiplas pendências. Verifique os erros abaixo."
                                    else ->
                                        resultado.mensagens.first()
                                }
                            },
                            onCarregarExemplo = {
                                curso = ModeloCurso().exemplo()
                                erros = emptyList()
                                statusMessage = "Exemplo carregado para análise."
                            },
                            onCadastrar = {
                                val resultado = CursoValidator.validar(curso)
                                if (resultado.valido) {
                                    cursos = cursos + curso
                                    curso = ModeloCurso()
                                    erros = emptyList()
                                    statusMessage = "Preencha os dados para gerar a visualização do curso."
                                    selectedTab = 0
                                } else {
                                    erros = resultado.mensagens
                                    statusMessage = when {
                                        resultado.mensagens.size > 1 ->
                                            "Há múltiplas pendências. Verifique os erros abaixo."
                                        else ->
                                            resultado.mensagens.first()
                                    }
                                }
                            }
                        )

                        // Lista de erros em vermelho abaixo dos botões
                        if (erros.isNotEmpty()) {
                            Spacer(Modifier.height(8.dp))
                            Column {
                                erros.forEach { erro ->
                                    Text(
                                        text = "• $erro",
                                        color = Color(0xFFE50914),
                                        style = MaterialTheme.typography.bodySmall,
                                        modifier = Modifier.padding(vertical = 2.dp)
                                    )
                                }
                            }
                        }

                        Spacer(Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}