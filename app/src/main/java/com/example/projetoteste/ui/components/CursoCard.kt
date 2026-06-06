package com.example.projetoteste.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetoteste.model.ModeloCurso
import com.example.projetoteste.ui.theme.ProjetoTesteTheme

@Composable
fun CursoCard(
    curso: ModeloCurso,
    selecionado: Boolean = false,
    onCursoClick: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val corBorda = if (selecionado) MaterialTheme.colorScheme.primary else Color.Transparent

    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(2.dp, corBorda, CardDefaults.shape)
            .clickable { onCursoClick(curso.id) },
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (selecionado) 8.dp else 2.dp
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = curso.nomeCompleto,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = curso.nomeBreve,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFE50914)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = curso.categoriaCurso,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Text(
                text = "Nível: ${curso.nivel.label}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Text(
                text = "Carga horária: ${curso.cargaHoraria}h",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Text(
                text = curso.status.label,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.SemiBold,
                color = when (curso.status.label) {
                    "Disponível" -> Color(0xFF2E7D32)
                    "Em breve"   -> Color(0xFFE65100)
                    else         -> Color(0xFFB71C1C)
                }
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "${curso.percentualProgresso.toInt()}% concluído",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
            Spacer(Modifier.height(4.dp))
            LinearProgressIndicator(
                progress = { (curso.percentualProgresso / 100).toFloat() },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true, name = "Card normal")
@Composable
fun PreviewCursoCard() {
    ProjetoTesteTheme {
        CursoCard(
            curso = ModeloCurso().exemplos()[0],
            selecionado = false,
            onCursoClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Card selecionado")
@Composable
fun PreviewCursoCardSelecionado() {
    ProjetoTesteTheme {
        CursoCard(
            curso = ModeloCurso().exemplos()[0],
            selecionado = true,
            onCursoClick = {}
        )
    }
}