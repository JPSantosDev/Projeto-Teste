package com.example.projetoteste.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.FilterChip
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetoteste.model.Nivel
import com.example.projetoteste.ui.theme.ProjetoTesteTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FiltroCursos(
    tipoFiltro: String,
    filtroSelecionado: String,
    categorias: List<String>,
    onTipoFiltroChange: (String) -> Unit,
    onFiltroChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {

        SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
            SegmentedButton(
                selected = tipoFiltro == "Nivel",
                onClick = {
                    onTipoFiltroChange("Nivel")
                    onFiltroChange("Todos")
                },
                shape = SegmentedButtonDefaults.itemShape(index = 0, count = 2)
            ) { Text("Nível") }

            SegmentedButton(
                selected = tipoFiltro == "Categoria",
                onClick = {
                    onTipoFiltroChange("Categoria")
                    onFiltroChange("Todos")
                },
                shape = SegmentedButtonDefaults.itemShape(index = 1, count = 2)
            ) { Text("Categoria") }
        }

        Spacer(Modifier.height(8.dp))

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            FilterChip(
                selected = filtroSelecionado == "Todos",
                onClick = { onFiltroChange("Todos") },
                label = { Text("Todos") }
            )

            if (tipoFiltro == "Nivel") {
                Nivel.values().forEach { nivel ->
                    FilterChip(
                        selected = filtroSelecionado == nivel.label,
                        onClick = { onFiltroChange(nivel.label) },
                        label = { Text(nivel.label) }
                    )
                }
            } else {
                categorias.forEach { categoria ->
                    FilterChip(
                        selected = filtroSelecionado == categoria,
                        onClick = { onFiltroChange(categoria) },
                        label = { Text(categoria) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFiltroCursos() {
    ProjetoTesteTheme {
        FiltroCursos(
            tipoFiltro = "Nivel",
            filtroSelecionado = "Todos",
            categorias = listOf("Mobile", "Web", "Back-end", "Design"),
            onTipoFiltroChange = {},
            onFiltroChange = {}
        )
    }
}