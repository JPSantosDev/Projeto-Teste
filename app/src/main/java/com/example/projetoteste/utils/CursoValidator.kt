package com.example.projetoteste.utils

import com.example.projetoteste.model.ModeloCurso

object CursoValidator{

    fun validar(curso: ModeloCurso):ValidacaoCursoResult{

        val erros = mutableListOf<String>()

        if(curso.nomeCompleto.trim().length>10)
            erros.add("Nome completo do curso deve ter no mínimo 10 caracteres")
        if(curso.categoriaCurso.trim().isEmpty())
            erros.add("Categoria não pode ficar vazia.")
        val cargaHorariaNumero = curso.cargaHoraria.toIntOrNull()

        if(cargaHorariaNumero == null || cargaHorariaNumero < 0)
            erros.add("Carga horaria deve ser um numero positivo")

        if(curso.descricaoCurta.length > 120)
            erros.add("Descricao curta deve ter no maximo 120 caracteres")

        return ValidacaoCursoResult( // Retorna um objeto único com a resposta completa da validação.
            valido = erros.isEmpty(), // Considera válido somente quando nenhuma regra adicionou pendência.
            mensagens = erros // Entrega todas as pendências para a tela montar uma mensagem clara.
        ) //

    }
}