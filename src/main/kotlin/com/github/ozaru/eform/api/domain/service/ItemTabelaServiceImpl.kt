package com.github.ozaru.eform.api.domain.service

import com.github.ozaru.eform.api.domain.repository.ItemTabelaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ItemTabelaServiceImpl(
    private val itemTabelaRepository: ItemTabelaRepository
) : ItemTabelaService {

    override fun obterTabela(nomeContem: String, inativo: Boolean, pageable: Pageable): Page<ItemTabelaService.Item> {
        return itemTabelaRepository.obterTabela(nomeContem, inativo, pageable)
    }

}