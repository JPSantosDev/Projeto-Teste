package com.example.projetoteste.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.projetoteste.R
import com.example.projetoteste.ui.theme.ProjetoTesteTheme
import com.example.projetoteste.ui.theme.VerdeEducacaoClaro
import org.jetbrains.annotations.Async

@Composable
fun ContainerImage(
    modifier: Modifier = Modifier
){
    Box(modifier = modifier
        .fillMaxWidth()
        .height(40.dp)
        .background(VerdeEducacaoClaro)
        .clip(RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_educacao_curso),
            contentDescription = null,

        )
    }
}

@Preview
@Composable
private fun ContainerImagePreview(){
    ProjetoTesteTheme() {
        ContainerImage()
    }
}
