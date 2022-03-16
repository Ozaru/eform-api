package com.github.ozaru.eform.api.application.controller

import com.github.ozaru.eform.api.domain.service.FornecedorTabelaService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.annotation.security.RolesAllowed


@RequestMapping("fornecedor-tabela")
@RestController
@Tag(name = "Tabela de fornecedores")
class FornecedorTabelaController(
    private val fornecedorTabelaService: FornecedorTabelaService
) {

    @GetMapping
    @RolesAllowed("fornecedor_tabela-abrir")
    fun obterTabela(
        pageable: Pageable,
        @RequestParam nomeContem: String,
        @RequestParam inativo: Boolean,
    ): Page<FornecedorTabelaService.Fornecedor> {
        return fornecedorTabelaService.obterTabela(nomeContem, inativo, pageable)
    }

}