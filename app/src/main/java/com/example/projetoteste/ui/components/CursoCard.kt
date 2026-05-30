package com.example.projetoteste.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
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
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = curso.nomeCompleto,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = curso.nomeBreve,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFE50914)
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = curso.categoriaCurso,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Text(
                text = "Carga horária: ${curso.cargaHoraria}h",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = curso.descricaoCurta,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true, name = "Card de curso salvo")
@Composable
fun PreviewCursoCard() {
    ProjetoTesteTheme {
        CursoCard(curso = ModeloCurso().exemplo())
    }
}