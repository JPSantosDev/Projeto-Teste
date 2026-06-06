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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.projetoteste.model.ModeloCurso
import com.example.projetoteste.ui.components.Busca
import com.example.projetoteste.ui.components.CursoCard
import com.example.projetoteste.ui.components.FiltroCursos

@Composable
fun MainScreen(
    cursos: List<ModeloCurso>,
    idSelecionado: Int?,
    onCursoClick: (ModeloCurso) -> Unit
) {
    var campoBusca by rememberSaveable { mutableStateOf("") }
    var filtroSelecionado by rememberSaveable { mutableStateOf("Todos") }
    var tipoFiltro by rememberSaveable { mutableStateOf("Nivel") }

    val categorias = cursos.map { it.categoriaCurso }.distinct()

    val cursosFiltrados = cursos.filter { curso ->
        val matchBusca =
            curso.nomeCompleto.contains(campoBusca, ignoreCase = true) ||
                    curso.nomeBreve.contains(campoBusca, ignoreCase = true) ||
                    curso.categoriaCurso.contains(campoBusca, ignoreCase = true)

        val matchFiltro = filtroSelecionado == "Todos" ||
                (tipoFiltro == "Nivel" && curso.nivel.label == filtroSelecionado) ||
                (tipoFiltro == "Categoria" && curso.categoriaCurso == filtroSelecionado)

        matchBusca && matchFiltro
    }

    Column(modifier = Modifier.fillMaxSize()) {

        FiltroCursos(
            tipoFiltro = tipoFiltro,
            filtroSelecionado = filtroSelecionado,
            categorias = categorias,
            onTipoFiltroChange = { tipoFiltro = it },
            onFiltroChange = { filtroSelecionado = it }
        )

        Spacer(Modifier.height(8.dp))

        Busca(
            modifier = Modifier.fillMaxWidth(),
            textValue = campoBusca,
            mudarTexto = { campoBusca = it }
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Cursos exibidos: ${cursosFiltrados.size}",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 4.dp)
        )

        Spacer(Modifier.height(8.dp))

        if (cursosFiltrados.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Nenhum curso encontrado",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Ajuste a busca ou altere o filtro selecionado.",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(cursosFiltrados, key = { it.id }) { item ->
                    CursoCard(
                        curso = item,
                        selecionado = idSelecionado == item.id,
                        onCursoClick = { onCursoClick(item) }
                    )
                }
            }
        }
    }
}