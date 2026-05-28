package com.example.projetoteste.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.projetoteste.R
import com.example.projetoteste.ui.theme.ProjetoTesteTheme

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
        Text(
            text = "NETCURSOS",
            style = TextStyle(
                fontFamily = BebasNeueFamily,
                fontSize = 64.sp,
                color = Color(0xFFE50914),
                letterSpacing = 6.sp
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CabecalhoCadastroPreview() {
    ProjetoTesteTheme {
        Cabecalho()
    }
}