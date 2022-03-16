package com.github.ozaru.eform.api.domain.service

import com.github.ozaru.eform.api.domain.repository.FornecedorTabelaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FornecedorTabelaServiceImpl(
    private val fornecedorTabelaRepository: FornecedorTabelaRepository
) : FornecedorTabelaService {

    override fun obterTabela(
        nomeContem: String,
        inativo: Boolean,
        pageable: Pageable
    ): Page<FornecedorTabelaService.Fornecedor> {
        return fornecedorTabelaRepository.obterTabela(nomeContem, inativo, pageable)
    }

}