package com.example.projetoteste.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetoteste.model.ModeloCurso
import com.example.projetoteste.model.Nivel
import com.example.projetoteste.model.Status
import com.example.projetoteste.ui.theme.ProjetoTesteTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioCurso(
    modifier: Modifier = Modifier,
    curso: ModeloCurso,
    onNomeCompletoChange: (String) -> Unit,
    onNomeBreveChange: (String) -> Unit,
    onCategoriaChange: (String) -> Unit,
    onCargaHorariaChange: (String) -> Unit,
    onDescricaoChange: (String) -> Unit,
    onSetDisponivel: () -> Unit,
    onSetIndisponivel: () -> Unit,
    onSetEmBreve: () -> Unit,
    onSetBasico: () -> Unit,
    onSetIntermediario: () -> Unit,
    onSetAvancado: () -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Dados do Curso",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = curso.nomeCompleto,
            onValueChange = onNomeCompletoChange,
            label = { Text("Nome completo do curso") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = curso.nomeBreve,
            onValueChange = onNomeBreveChange,
            label = { Text("Nome breve") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = curso.categoriaCurso,
            onValueChange = onCategoriaChange,
            label = { Text("Categoria") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = curso.cargaHoraria,
            onValueChange = onCargaHorariaChange,
            label = { Text("Carga horária") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = curso.descricaoCurta,
            onValueChange = onDescricaoChange,
            label = { Text("Descrição curta") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))
        Column (modifier = Modifier.fillMaxWidth()) {

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                TextField(
                    value = when(curso.status){
                        Status.DISPONIVEL -> "Disponível"
                        Status.INDISPONIVEL -> "Indisponível"
                        Status.EM_BREVE -> "Em Breve"
                    },
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Status") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Disponível") },
                        onClick = {
                            onSetBasico()
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Indisponível") },
                        onClick = {
                            onSetIndisponivel()
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Em Breve") },
                        onClick = {
                            onSetEmBreve()
                            expanded = false
                        }
                    )

                }
            }
            Spacer(Modifier.height(10.dp))
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                TextField(
                    value = when(curso.nivel){
                        Nivel.BASICO -> "Básico"
                        Nivel.INTERMEDIARIO -> "Intermediário"
                        Nivel.AVANCADO -> "Avançado"
                    },
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Nível") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Básico") },
                        onClick = {
                            onSetBasico()
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Intermediário") },
                        onClick = {
                            onSetIntermediario()
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Avançado") },
                        onClick = {
                            onSetAvancado()
                            expanded = false
                        }
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFormularioCurso() {
    ProjetoTesteTheme {
        FormularioCurso(
            curso = ModeloCurso().exemplos()[0],
            onNomeCompletoChange = {},
            onCategoriaChange = {},
            onDescricaoChange = {},
            onNomeBreveChange = {},
            onCargaHorariaChange = {},
            onSetEmBreve = {},
            onSetDisponivel = {},
            onSetIndisponivel = {},
            onSetAvancado = {},
            onSetBasico = {},
            onSetIntermediario = {}
        )
    }
}