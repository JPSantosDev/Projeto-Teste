package com.example.projetoteste.utils

import com.example.projetoteste.model.ModeloCurso
import com.example.projetoteste.model.ResultadoValidado

object CursoValidator {

    fun validar(curso: ModeloCurso): ResultadoValidado {
        val erros = mutableListOf<String>()

        if(curso.id <= 0)
            erros.add("O id deve ser um valor positivo acima de zero")
        if (curso.nomeCompleto.trim().length < 10)
            erros.add("O nome completo precisa ser mais descritivo (mínimo 10 caracteres).")
        if (curso.nomeBreve.trim().length > 20)
            erros.add("O nome breve deve ser reduzido (máximo 20 caracteres).")
        if (curso.categoriaCurso.trim().isEmpty())
            erros.add("A categoria é obrigatória.")
        if (curso.cargaHoraria.trim().isEmpty()) {
            erros.add("A carga horária é obrigatória.")
        } else {
            val cargaHorariaNumero = curso.cargaHoraria.toIntOrNull()
            when {
                cargaHorariaNumero == null ->
                    erros.add("A carga horária deve ser numérica.")
                cargaHorariaNumero <= 0 ->
                    erros.add("A carga horária deve ser positiva.")
            }
        }

        if (curso.descricaoCurta.length > 120)
            erros.add("A descrição ultrapassou o limite permitido de 120 caracteres.")

        return ResultadoValidado(
            valido = erros.isEmpty(),
            mensagens = erros
        )
    }
}