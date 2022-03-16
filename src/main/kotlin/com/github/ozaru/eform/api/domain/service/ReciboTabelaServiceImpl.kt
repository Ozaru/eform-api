package com.github.ozaru.eform.api.domain.service

import com.github.ozaru.eform.api.domain.enums.ReciboStatusEnum
import com.github.ozaru.eform.api.domain.exception.AppException
import com.github.ozaru.eform.api.domain.repository.ReciboTabelaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.time.LocalDateTime

@Service
@Transactional
class ReciboTabelaServiceImpl(
    private val reciboTabelaRepository: ReciboTabelaRepository
) : ReciboTabelaService {

    override fun obterTabela(
        id: Long?,
        usuarioId: Long?,
        fornecedorId: Long?,
        dataInicial: LocalDateTime?,
        dataFinal: LocalDateTime?,
        valorInicial: BigDecimal?,
        valorFinal: BigDecimal?,
        status: ReciboStatusEnum?,
        pageable: Pageable
    ): Page<ReciboTabelaService.Recibo> {
        if (dataInicial != null && dataFinal != null) {
            if (dataInicial.isAfter(dataFinal)) {
                throw AppException("[dataInicial] deve ser menor que [dataFinal]")
            }
        }
        if (valorInicial != null && valorFinal != null) {
            if (valorInicial.compareTo(valorFinal) > 0) {
                throw AppException("[valorInicial] deve ser menor que [valorFinal]")
            }
        }
        return reciboTabelaRepository.obterTabela(
            id,
            usuarioId,
            fornecedorId,
            dataInicial,
            dataFinal,
            valorInicial,
            valorFinal,
            status,
            pageable
        )
    }

    override fun obterFiltroUsuarios(): List<ReciboTabelaService.Usuario> {
        return reciboTabelaRepository.obterFiltroUsuarios()
    }

    override fun obterFiltroFornecedores(): List<ReciboTabelaService.Fornecedor> {
        return reciboTabelaRepository.obterFiltroFornecedores()
    }

    override fun obterFiltroStatus(): List<ReciboTabelaService.Status> {
        return ReciboStatusEnum.values().map { status ->
            ReciboTabelaService.Status(
                nome = status.name,
                texto = status.texto
            )
        }
    }

}