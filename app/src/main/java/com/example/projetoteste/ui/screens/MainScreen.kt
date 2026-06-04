package com.example.projetoteste.ui.screens

import android.graphics.ColorSpace
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import com.example.projetoteste.model.ModeloCurso
import com.example.projetoteste.ui.components.Busca
import com.example.projetoteste.ui.components.CursoCard
import com.example.projetoteste.ui.screens.CoursesScreen


@Composable
fun MainScreen(
    cursos: List<ModeloCurso>
){

    var campoBusca by remember { mutableStateOf("") }

    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
        Busca(
            textValue = campoBusca,
            mudarTexto = { campoBusca = it }
        )
    }

    if (cursos.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Nenhum curso cadastrado ainda.", color = Color.Gray)
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {

            items(cursos.filter {
                        it.nomeCompleto.contains(campoBusca, ignoreCase = true) ||
                        it.nomeBreve.contains(campoBusca, ignoreCase = true)||
                        it.categoriaCurso.contains(campoBusca, ignoreCase = true)})
            { item ->
                CursoCard(curso = item)
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}