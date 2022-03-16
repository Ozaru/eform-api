package com.github.ozaru.eform.api.application.controller

import com.github.ozaru.eform.api.domain.service.ItemFormService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RequestMapping("item-form")
@RestController
@Tag(name = "Formulário de item")
class ItemFormController(
    private val itemFormService: ItemFormService
) {

    @GetMapping("{id}")
    fun obterFormulario(
        @PathVariable id: Long
    ): ItemFormService.Item {
        return itemFormService.obterFormulario(id)
    }

    @PostMapping
    fun salvarFormulario(@RequestBody item: ItemFormService.Item): Long {
        return itemFormService.salvarFormulario(item)
    }

}