package com.example.projetoteste.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetoteste.ui.theme.ProjetoTesteTheme
import com.example.projetoteste.ui.theme.VerdeEducacaoClaro
import com.example.projetoteste.R

@Composable
fun ContainerImage(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(132.dp)
            .background(Color.Transparent)
            .clip(RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Ícone do aplicativo",
            modifier = Modifier.size(348.dp)
        )
    }
}

@Preview
@Composable
private fun ContainerImagePreview() {
    ProjetoTesteTheme {
        ContainerImage()
    }
}