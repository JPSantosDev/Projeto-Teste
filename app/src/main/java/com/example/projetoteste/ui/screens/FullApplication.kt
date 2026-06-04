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
fun FullApplication(modifier: Modifier = Modifier){

    var selectedTab by remember { mutableIntStateOf(0) }
    var curso by remember { mutableStateOf(ModeloCurso()) }
    var cursos by remember { mutableStateOf(listOf<ModeloCurso>()) }
    var statusMessage by remember { mutableStateOf("Preencha os dados para gerar a visualização do curso.")}
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
                    MainScreen(cursos)
                }

                1 -> {
                    CoursesScreen(
                        cursos,
                        onCadastrar = {cursos = cursos+it},
                        onNavegar = {selectedTab = 0}
                    )
                }
            }
        }
    }
}