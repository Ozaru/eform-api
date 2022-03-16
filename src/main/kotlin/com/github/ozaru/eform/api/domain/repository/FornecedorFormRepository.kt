package com.github.ozaru.eform.api.domain.repository

import com.github.ozaru.eform.api.domain.service.FornecedorFormService

interface FornecedorFormRepository {

    fun obterFormulario(id: Long): FornecedorFormService.Fornecedor?
    fun salvarFormulario(fornecedor: FornecedorFormService.Fornecedor): Long

}