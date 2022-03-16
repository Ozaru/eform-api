package com.github.ozaru.eform.api.repository

import com.github.ozaru.eform.api.domain.repository.FornecedorFormRepository
import com.github.ozaru.eform.api.domain.service.FornecedorFormService
import com.github.ozaru.eform.api.repository.entity.Fornecedor
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class FornecedorFormRepositoryImpl(
    private val fornecedorDAO: FornecedorDAO
) : FornecedorFormRepository {

    override fun obterFormulario(id: Long): FornecedorFormService.Fornecedor? {
        fornecedorDAO.findByIdOrNull(id)?.also {
            return FornecedorFormService.Fornecedor(
                id = it.id,
                nome = it.nome,
                ativo = it.ativo
            )
        }
        return null
    }

    override fun salvarFormulario(fornecedor: FornecedorFormService.Fornecedor): Long {
        return fornecedorDAO.save(
            Fornecedor(
                id = fornecedor.id ?: 0L,
                nome = fornecedor.nome,
                ativo = fornecedor.ativo
            )
        ).id
    }

}