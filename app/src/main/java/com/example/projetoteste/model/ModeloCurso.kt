package com.example.projetoteste.model

data class ModeloCurso (
    val nomeCompleto: String = "",
    val nomeBreve: String = "",
    val categoriaCurso:String = "",
    val cargaHoraria: String = "",
    val descricaoCurta: String = ""
){

    fun exemplo(): ModeloCurso{
        return ModeloCurso(
            nomeCompleto = "Curso Tecnico em Desenvolvimento de Sistemas",
            nomeBreve = "Desenv. Sistemas",
            categoriaCurso = "Tecnologia da Informacao",
            cargaHoraria = "1200",
            descricaoCurta = "Formacao tecnica para criar aplicativos, sistemas web e solucoes digitais."
        )
    }
}