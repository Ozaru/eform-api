package com.github.ozaru.eform.api.domain.repository

import com.github.ozaru.eform.api.domain.service.ItemFormService

interface ItemFormRepository {

    fun obterFormulario(id: Long): ItemFormService.Item?
    fun salvarFormulario(item: ItemFormService.Item): Long

}