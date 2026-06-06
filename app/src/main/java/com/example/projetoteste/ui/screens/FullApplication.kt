package com.example.projetoteste.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetoteste.model.ModeloCurso
import com.example.projetoteste.ui.components.Cabecalho

@Preview
@Composable
fun FullApplication(modifier: Modifier = Modifier) {

    var selectedTab by remember { mutableIntStateOf(0) }
    var cursos by remember { mutableStateOf(ModeloCurso().exemplos()) }
    var cursoSelecionado by remember { mutableStateOf<ModeloCurso?>(null) }
    var idSelecionado by remember { mutableStateOf<Int?>(null) }

    val cursoAtual = cursoSelecionado

    if (cursoAtual != null) {
        CursoDetalhe(
            curso = cursoAtual,
            onVoltar = { cursoSelecionado = null }
        )
    } else {
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
                        MainScreen(
                            cursos = cursos,
                            idSelecionado = idSelecionado,
                            onCursoClick = { curso ->
                                idSelecionado = curso.id
                                cursoSelecionado = curso
                            }
                        )
                    }
                    1 -> {
                        CoursesScreen(
                            cursos = cursos,
                            onCadastrar = { cursos = cursos + it },
                            onNavegar = { selectedTab = 0 }
                        )
                    }
                }
            }
        }
    }
}