package com.github.ozaru.eform.api.repository

import com.github.ozaru.eform.api.domain.repository.ItemFormRepository
import com.github.ozaru.eform.api.domain.service.ItemFormService
import com.github.ozaru.eform.api.repository.entity.Item
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ItemFormRepositoryImpl(
    private val itemDAO: ItemDAO
) : ItemFormRepository {

    override fun obterFormulario(id: Long): ItemFormService.Item? {
        itemDAO.findByIdOrNull(id)?.also {
            return ItemFormService.Item(
                id = it.id,
                nome = it.nome,
                ativo = it.ativo
            )
        }
        return null
    }

    override fun salvarFormulario(item: ItemFormService.Item): Long {
        return itemDAO.save(
            Item(
                id = item.id ?: 0L,
                nome = item.nome,
                ativo = item.ativo
            )
        ).id
    }

}