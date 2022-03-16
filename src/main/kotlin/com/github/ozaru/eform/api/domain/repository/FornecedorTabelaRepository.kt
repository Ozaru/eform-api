package com.github.ozaru.eform.api.domain.repository

import com.github.ozaru.eform.api.domain.service.FornecedorTabelaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface FornecedorTabelaRepository {

    fun obterTabela(nomeContem: String, inativo: Boolean, pageable: Pageable): Page<FornecedorTabelaService.Fornecedor>

}