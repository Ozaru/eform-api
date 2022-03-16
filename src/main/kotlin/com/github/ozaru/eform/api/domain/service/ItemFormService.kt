package com.github.ozaru.eform.api.domain.service

interface ItemFormService {

    fun obterFormulario(id: Long): Item
    fun salvarFormulario(item: Item): Long

    data class Item(
        val id: Long?,
        val nome: String,
        val ativo: Boolean
    )

}