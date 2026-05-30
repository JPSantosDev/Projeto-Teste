package com.example.projetoteste.ui.components

import android.graphics.ColorSpace
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
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.projetoteste.model.ModeloCurso


@Composable
fun CursoCard(
    curso: ModeloCurso,
    modifier:Modifier = Modifier
){
    Card(
        modifier = modifier
            .fillMaxWidth()

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = curso.nomeCompleto,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier.height(16.dp))
            Text(
                text = curso.categoriaCurso,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Text(
                text = "Carga Horária: ${curso.cargaHoraria}h",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}