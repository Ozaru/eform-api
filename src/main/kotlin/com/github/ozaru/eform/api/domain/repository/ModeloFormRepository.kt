package com.github.ozaru.eform.api.domain.repository

import com.github.ozaru.eform.api.domain.service.ModeloFormService

interface ModeloFormRepository {

    fun obterFormulario(id: Long): ModeloFormService.Modelo?
    fun salvarFormulario(modelo: ModeloFormService.Modelo): Long

}