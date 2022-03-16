package com.github.ozaru.eform.api.repository

import com.github.ozaru.eform.api.domain.repository.ModeloTabelaRepository
import com.github.ozaru.eform.api.domain.service.ModeloTabelaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class ModeloTabelaRepositoryImpl(
    private val modeloDAO: ModeloDAO
) : ModeloTabelaRepository {

    override fun obterTabela(
        nomeContem: String,
        inativo: Boolean,
        pageable: Pageable
    ): Page<ModeloTabelaService.Modelo> {
        val pagina = if (!inativo) {
            modeloDAO.findAllByNomeContainingIgnoreCaseAndAtivoTrue(nomeContem, pageable)
        } else {
            modeloDAO.findAllByNomeContainingIgnoreCase(nomeContem, pageable)
        }
        return pagina.map {
            ModeloTabelaService.Modelo(
                id = it.id,
                nome = it.nome,
                ativo = it.ativo
            )
        }
    }

}