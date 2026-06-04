package com.example.projetoteste.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetoteste.ui.theme.ProjetoTesteTheme
import com.example.projetoteste.R
import kotlin.math.round

val BebasNeueFamily = FontFamily(
    Font(R.font.bebas_neue, FontWeight.Normal)
)

@Composable
fun Cabecalho(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Black)
        ) {
            Text(
                text = "Catálogo Aprender+",
                style = TextStyle(
                    fontFamily = BebasNeueFamily,
                    fontSize = 32.sp,
                    color = Color(0xFFE50914),
                    letterSpacing = 6.sp
                )
            )
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
        ) {
            Text(
                text = "Explore cursos técnicos e profissionalizantes.",
                color = Color(0xFFE50914)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CabecalhoCadastroPreview() {
    ProjetoTesteTheme {
        Cabecalho()
    }
}