package com.example.projetoteste.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.projetoteste.model.ModeloCurso
import com.example.projetoteste.ui.components.CadastrarButtons
import com.example.projetoteste.ui.components.ContainerImage
import com.example.projetoteste.ui.components.FormularioCurso
import com.example.projetoteste.utils.CursoValidator
import kotlin.text.ifEmpty


@Composable
fun CoursesScreen(
    cursos: List<ModeloCurso>,
    onCadastrar: (ModeloCurso) -> Unit,
    onNavegar: () -> Unit
){
    var selectedTab by remember { mutableIntStateOf(1) }
    var curso by remember { mutableStateOf(ModeloCurso()) }
    var erros by remember { mutableStateOf<List<String>>(emptyList()) }
    var statusMessage by remember { mutableStateOf("Preencha os dados para gerar a visualização do curso.")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(8.dp))

        ContainerImage()

        Spacer(Modifier.height(16.dp))
        Text(
            text = "Cadastro Visual de Cursos",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = "Monte a apresentação inicial de um curso técnico.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(Modifier.height(16.dp))

        FormularioCurso(
            curso = curso,
            onNomeCompletoChange = { curso = curso.copy(nomeCompleto = it) },
            onNomeBreveChange = { curso = curso.copy(nomeBreve = it) },
            onCategoriaChange = { curso = curso.copy(categoriaCurso = it) },
            onCargaHorariaChange = { curso = curso.copy(cargaHoraria = it) },
            onDescricaoChange = { curso = curso.copy(descricaoCurta = it) }
        )

        Spacer(Modifier.height(16.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Pré-visualização do curso",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = curso.nomeBreve.ifEmpty { "Nome breve não informado" },
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFE50914)
                )
                Text(
                    text = curso.nomeCompleto.ifEmpty { "Nome completo não informado" },
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = curso.categoriaCurso.ifEmpty { "Categoria pendente" },
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                Text(
                    text = if (curso.cargaHoraria.isEmpty())
                        "Carga horária pendente"
                    else
                        "Carga horária: ${curso.cargaHoraria}h",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                Text(
                    text = curso.descricaoCurta.ifEmpty { "Descrição ainda não preenchida" },
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }

        Spacer(Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))
        ) {
            Text(
                text = statusMessage,
                modifier = Modifier.padding(12.dp),
                style = MaterialTheme.typography.bodySmall,
                color = Color.LightGray
            )
        }

        Spacer(Modifier.height(12.dp))
        CadastrarButtons(
            onLimpar = {
                curso = ModeloCurso()
                erros = emptyList()
                statusMessage = "Formulário limpo."
            },
            onValidar = {
                val resultado = CursoValidator.validar(curso)
                erros = resultado.mensagens
                statusMessage = when {
                    resultado.valido ->
                        "Cadastro visual válido para apresentação."
                    resultado.mensagens.size > 1 ->
                        "Há múltiplas pendências. Verifique os erros abaixo."
                    else ->
                        resultado.mensagens.first()
                }
            },
            onCarregarExemplo = {
                curso = ModeloCurso().exemplo()
                erros = emptyList()
                statusMessage = "Exemplo carregado para análise."
            },
            onCadastrar = {
                val resultado = CursoValidator.validar(curso)
                if (resultado.valido) {
                    onCadastrar(curso)
                    curso = ModeloCurso()
                    erros = emptyList()
                    statusMessage = "Preencha os dados para gerar a visualização do curso."
                    onNavegar()
                } else {
                    erros = resultado.mensagens
                    statusMessage = when {
                        resultado.mensagens.size > 1 ->
                            "Há múltiplas pendências. Verifique os erros abaixo."
                        else ->
                            resultado.mensagens.first()
                    }
                }
            }
        )

        // Lista de erros em vermelho abaixo dos botões
        if (erros.isNotEmpty()) {
            Spacer(Modifier.height(8.dp))
            Column {
                erros.forEach { erro ->
                    Text(
                        text = "• $erro",
                        color = Color(0xFFE50914),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))
    }
}