package com.github.ozaru.eform.api.domain.repository

import com.github.ozaru.eform.api.domain.service.ItemTabelaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ItemTabelaRepository {

    fun obterTabela(nomeContem: String, inativo: Boolean, pageable: Pageable): Page<ItemTabelaService.Item>

}