package com.github.ozaru.eform.api.application.controller

import com.github.ozaru.eform.api.domain.service.FornecedorFormService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RequestMapping("fornecedor-form")
@RestController
@Tag(name = "Formulário de fornecedor")
class FornecedorFormController(
    private val fornecedorFormService: FornecedorFormService
) {

    @GetMapping("{id}")
    fun obterFormulario(
        @PathVariable id: Long
    ): FornecedorFormService.Fornecedor {
        return fornecedorFormService.obterFormulario(id)
    }

    @PostMapping
    fun salvarFormulario(@RequestBody fornecedor: FornecedorFormService.Fornecedor): Long {
        return fornecedorFormService.salvarFormulario(fornecedor)
    }

}