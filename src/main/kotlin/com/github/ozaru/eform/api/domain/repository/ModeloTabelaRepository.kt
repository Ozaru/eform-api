package com.github.ozaru.eform.api.domain.repository

import com.github.ozaru.eform.api.domain.service.ModeloTabelaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ModeloTabelaRepository {

    fun obterTabela(nomeContem: String, inativo: Boolean, pageable: Pageable): Page<ModeloTabelaService.Modelo>

}