package com.github.ozaru.eform.api.domain.service

import com.github.ozaru.eform.api.domain.exception.AppException
import com.github.ozaru.eform.api.domain.repository.ItemFormRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ItemFormServiceImpl(
    private val itemFormRepository: ItemFormRepository
) : ItemFormService {

    override fun obterFormulario(id: Long): ItemFormService.Item {
        return itemFormRepository.obterFormulario(id) ?: throw AppException("[itemForm.id] - nao encontrado")
    }

    override fun salvarFormulario(item: ItemFormService.Item): Long {
        if (item.nome.isBlank() || item.nome.length > 50) {
            throw AppException("[item.nome] - nao pode ser vazio, nem pode ter mais de 50 caracteres")
        }
        return itemFormRepository.salvarFormulario(item)
    }

}