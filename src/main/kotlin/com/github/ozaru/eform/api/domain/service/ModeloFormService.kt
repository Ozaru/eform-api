package com.github.ozaru.eform.api.domain.service

interface ModeloFormService {

    fun obterFormulario(id: Long): Modelo
    fun salvarFormulario(modelo: Modelo): Long

    data class Modelo(
        val id: Long?,
        val nome: String,
        val ativo: Boolean
    )

}