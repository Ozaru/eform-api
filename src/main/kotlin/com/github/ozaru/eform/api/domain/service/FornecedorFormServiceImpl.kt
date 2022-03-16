package com.github.ozaru.eform.api.domain.service

import com.github.ozaru.eform.api.domain.exception.AppException
import com.github.ozaru.eform.api.domain.repository.FornecedorFormRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FornecedorFormServiceImpl(
    private val fornecedorFormRepository: FornecedorFormRepository
) : FornecedorFormService {

    override fun obterFormulario(id: Long): FornecedorFormService.Fornecedor {
        return fornecedorFormRepository.obterFormulario(id)
            ?: throw AppException("[fornecedorForm.id] - nao encontrado")
    }

    override fun salvarFormulario(fornecedor: FornecedorFormService.Fornecedor): Long {
        if (fornecedor.nome.isBlank() || fornecedor.nome.length > 50) {
            throw AppException("[fornecedor.nome] - nao pode ser vazio, nem pode ter mais de 50 caracteres")
        }
        return fornecedorFormRepository.salvarFormulario(fornecedor)
    }

}