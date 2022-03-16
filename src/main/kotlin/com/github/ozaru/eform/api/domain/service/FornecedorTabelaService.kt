package com.github.ozaru.eform.api.domain.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface FornecedorTabelaService {

    fun obterTabela(nomeContem: String, inativo: Boolean, pageable: Pageable): Page<Fornecedor>

    data class Fornecedor(
        val id: Long?,
        var nome: String,
        var ativo: Boolean
    )

}