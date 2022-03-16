package com.github.ozaru.eform.api.domain.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ModeloTabelaService {

    fun obterTabela(nomeContem: String, inativo: Boolean, pageable: Pageable): Page<Modelo>

    data class Modelo(
        val id: Long?,
        var nome: String,
        var ativo: Boolean
    )

}