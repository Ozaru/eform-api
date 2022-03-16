package com.github.ozaru.eform.api.domain.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ItemTabelaService {

    fun obterTabela(nomeContem: String, inativo: Boolean, pageable: Pageable): Page<Item>

    data class Item(
        val id: Long?,
        var nome: String,
        var ativo: Boolean
    )

}