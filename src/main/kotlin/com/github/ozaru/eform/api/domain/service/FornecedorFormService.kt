package com.github.ozaru.eform.api.domain.service

interface FornecedorFormService {

    fun obterFormulario(id: Long): Fornecedor
    fun salvarFormulario(fornecedor: Fornecedor): Long

    data class Fornecedor(
        val id: Long?,
        val nome: String,
        val ativo: Boolean
    )

}