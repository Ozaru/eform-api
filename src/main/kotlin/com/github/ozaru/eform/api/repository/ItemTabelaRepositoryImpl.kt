package com.github.ozaru.eform.api.repository

import com.github.ozaru.eform.api.domain.repository.ItemTabelaRepository
import com.github.ozaru.eform.api.domain.service.ItemTabelaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class ItemTabelaRepositoryImpl(
    private val itemDAO: ItemDAO
) : ItemTabelaRepository {

    override fun obterTabela(nomeContem: String, inativo: Boolean, pageable: Pageable): Page<ItemTabelaService.Item> {
        val pagina = if (!inativo) {
            itemDAO.findAllByNomeContainingIgnoreCaseAndAtivoTrue(nomeContem, pageable)
        } else {
            itemDAO.findAllByNomeContainingIgnoreCase(nomeContem, pageable)
        }
        return pagina.map {
            ItemTabelaService.Item(
                id = it.id,
                nome = it.nome,
                ativo = it.ativo
            )
        }
    }

}