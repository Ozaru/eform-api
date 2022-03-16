package com.github.ozaru.eform.api.domain.service

import com.github.ozaru.eform.api.domain.repository.ModeloTabelaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ModeloTabelaServiceImpl(
    private val modeloTabelaRepository: ModeloTabelaRepository
) : ModeloTabelaService {

    override fun obterTabela(
        nomeContem: String,
        inativo: Boolean,
        pageable: Pageable
    ): Page<ModeloTabelaService.Modelo> {
        return modeloTabelaRepository.obterTabela(nomeContem, inativo, pageable)
    }

}