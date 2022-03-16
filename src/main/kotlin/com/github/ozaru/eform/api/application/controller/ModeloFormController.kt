package com.github.ozaru.eform.api.application.controller

import com.github.ozaru.eform.api.domain.service.ModeloFormService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RequestMapping("modelo-form")
@RestController
@Tag(name = "Formulário de modelo")
class ModeloFormController(
    private val modeloFormService: ModeloFormService
) {

    @GetMapping("{id}")
    fun obterFormulario(
        @PathVariable id: Long
    ): ModeloFormService.Modelo {
        return modeloFormService.obterFormulario(id)
    }

    @PostMapping
    fun salvarFormulario(@RequestBody modelo: ModeloFormService.Modelo): Long {
        return modeloFormService.salvarFormulario(modelo)
    }

}