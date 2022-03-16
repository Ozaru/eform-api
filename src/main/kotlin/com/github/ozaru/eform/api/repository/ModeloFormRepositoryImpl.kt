package com.github.ozaru.eform.api.repository

import com.github.ozaru.eform.api.domain.repository.ModeloFormRepository
import com.github.ozaru.eform.api.domain.service.ModeloFormService
import com.github.ozaru.eform.api.repository.entity.Modelo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ModeloFormRepositoryImpl(
    private val modeloDAO: ModeloDAO
) : ModeloFormRepository {

    override fun obterFormulario(id: Long): ModeloFormService.Modelo? {
        modeloDAO.findByIdOrNull(id)?.also {
            return ModeloFormService.Modelo(
                id = it.id,
                nome = it.nome,
                ativo = it.ativo
            )
        }
        return null
    }

    override fun salvarFormulario(modelo: ModeloFormService.Modelo): Long {
        return modeloDAO.save(
            Modelo(
                id = modelo.id ?: 0L,
                nome = modelo.nome,
                ativo = modelo.ativo
            )
        ).id
    }

}