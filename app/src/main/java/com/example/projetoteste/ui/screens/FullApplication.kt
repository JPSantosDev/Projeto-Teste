package com.example.projetoteste.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetoteste.model.ModeloCurso
import com.example.projetoteste.ui.components.CadastrarButtons
import com.example.projetoteste.ui.components.Cabecalho
import com.example.projetoteste.ui.components.CadastrarButtons
import com.example.projetoteste.ui.components.ContainerImage
import com.example.projetoteste.ui.components.CursoCard
import com.example.projetoteste.ui.components.FormularioCurso

@Preview
@Composable
fun FullApplication(modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableIntStateOf(0) }
    var curso by remember { mutableStateOf(ModeloCurso()) }
    var cursos by remember { mutableStateOf(listOf<ModeloCurso>()) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF1A1A1A)) {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
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
                    icon = { Icon(Icons.Default.Add, contentDescription = null) },
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
                        ContainerImage()
                        FormularioCurso(
                            curso = curso,
                            onNomeCompletoChange = { curso = curso.copy(nomeCompleto = it) },
                            onNomeBreveChange = { curso = curso.copy(nomeBreve = it) },
                            onCategoriaChange = { curso = curso.copy(categoriaCurso = it) },
                            onCargaHorariaChange = { curso = curso.copy(cargaHoraria = it) },
                            onDescricaoChange = { curso = curso.copy(descricaoCurta = it) }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        CadastrarButtons(
                            onCadastrar = {
                                if (curso.nomeCompleto.isNotBlank()) {
                                    cursos = cursos + curso
                                    curso = ModeloCurso()
                                    selectedTab = 0
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}