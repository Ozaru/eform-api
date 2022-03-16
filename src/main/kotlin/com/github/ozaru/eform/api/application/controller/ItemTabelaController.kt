package com.github.ozaru.eform.api.application.controller

import com.github.ozaru.eform.api.domain.service.ItemTabelaService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.annotation.security.RolesAllowed


@RequestMapping("item-tabela")
@RestController
@Tag(name = "Tabela de itens")
class ItemTabelaController(
    private val itemTabelaService: ItemTabelaService
) {

    @GetMapping
    @RolesAllowed("item_tabela-abrir")
    fun obterTabela(
        pageable: Pageable,
        @RequestParam nomeContem: String,
        @RequestParam inativo: Boolean,
    ): Page<ItemTabelaService.Item> {
        return itemTabelaService.obterTabela(nomeContem, inativo, pageable)
    }

}