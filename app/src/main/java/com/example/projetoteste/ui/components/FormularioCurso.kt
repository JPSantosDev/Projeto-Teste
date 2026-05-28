package com.example.projetoteste.ui.components

import android.R.attr.label
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetoteste.model.ModeloCurso
import com.example.projetoteste.ui.theme.ProjetoTesteTheme

@Composable
fun FormularioCurso(
    modifier: Modifier = Modifier,
    curso: ModeloCurso,
    onNomeCompletoChange: (String) -> Unit,
    onNomeBreveChange: (String) -> Unit,
    onCategoriaChange: (String) -> Unit,
    onCargaHorariaChange: (String) -> Unit,
    onDescricaoChange: (String) -> Unit,

){
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Dados do Curso",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier.height(10.dp))
        OutlinedTextField(
            value = curso.nomeCompleto,
            onValueChange = onNomeCompletoChange,
            label = { Text("Nome completo do curso") },
            singleLine = true,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier.height(10.dp))
        OutlinedTextField(
            value = curso.nomeBreve,
            onValueChange = onNomeBreveChange,
            label = { Text("Nome Breve") },
            singleLine = true,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier.height(10.dp))
        OutlinedTextField(
            value = curso.categoriaCurso,
            onValueChange = onCategoriaChange,
            label = { Text("Categoria") },
            singleLine = true,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier.height(10.dp))
        OutlinedTextField(
            value = curso.cargaHoraria,
            onValueChange = onCargaHorariaChange,
            label = { Text("Carga Horária") },
            singleLine = true,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier.height(10.dp))
        OutlinedTextField(
            value = curso.descricaoCurta,
            onValueChange = onDescricaoChange,
            label = { Text("Descrição Curta") },
            singleLine = true,
            modifier = modifier.fillMaxWidth()
        )
    }
}


@Preview (showBackground = true)
@Composable
fun PreviewFormularioCurso(){
    ProjetoTesteTheme() {
        FormularioCurso(
            curso = ModeloCurso().exemplo(),
            onNomeCompletoChange = {},
            onCategoriaChange = {},
            onDescricaoChange = {},
            onNomeBreveChange = {},
            onCargaHorariaChange = {}
        )
    }
}