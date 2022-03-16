package com.github.ozaru.eform.api.repository

import com.github.ozaru.eform.api.domain.repository.FornecedorTabelaRepository
import com.github.ozaru.eform.api.domain.service.FornecedorTabelaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class FornecedorTabelaRepositoryImpl(
    private val fornecedorDAO: FornecedorDAO
) : FornecedorTabelaRepository {

    override fun obterTabela(
        nomeContem: String,
        inativo: Boolean,
        pageable: Pageable
    ): Page<FornecedorTabelaService.Fornecedor> {
        val pagina = if (!inativo) {
            fornecedorDAO.findAllByNomeContainingIgnoreCaseAndAtivoTrue(nomeContem, pageable)
        } else {
            fornecedorDAO.findAllByNomeContainingIgnoreCase(nomeContem, pageable)
        }
        return pagina.map {
            FornecedorTabelaService.Fornecedor(
                id = it.id,
                nome = it.nome,
                ativo = it.ativo
            )
        }
    }

}