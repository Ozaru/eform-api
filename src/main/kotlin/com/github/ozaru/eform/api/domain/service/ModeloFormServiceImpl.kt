package com.github.ozaru.eform.api.domain.service

import com.github.ozaru.eform.api.domain.exception.AppException
import com.github.ozaru.eform.api.domain.repository.ModeloFormRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ModeloFormServiceImpl(
    private val modeloFormRepository: ModeloFormRepository
) : ModeloFormService {

    override fun obterFormulario(id: Long): ModeloFormService.Modelo {
        return modeloFormRepository.obterFormulario(id) ?: throw AppException("[modeloForm.id] - nao encontrado")
    }

    override fun salvarFormulario(modelo: ModeloFormService.Modelo): Long {
        if (modelo.nome.isBlank() || modelo.nome.length > 50) {
            throw AppException("[modelo.nome] - nao pode ser vazio, nem pode ter mais de 50 caracteres")
        }
        return modeloFormRepository.salvarFormulario(modelo)
    }

}