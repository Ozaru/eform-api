package com.github.ozaru.eform.api.domain.repository

import com.github.ozaru.eform.api.domain.enums.ReciboStatusEnum
import com.github.ozaru.eform.api.domain.service.ReciboTabelaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.math.BigDecimal
import java.time.LocalDateTime

interface ReciboTabelaRepository {

    fun obterTabela(
        id: Long?,
        usuarioId: Long?,
        fornecedorId: Long?,
        dataInicial: LocalDateTime?,
        dataFinal: LocalDateTime?,
        valorInicial: BigDecimal?,
        valorFinal: BigDecimal?,
        status: ReciboStatusEnum?,
        pageable: Pageable
    ): Page<ReciboTabelaService.Recibo>

    fun obterFiltroUsuarios(): List<ReciboTabelaService.Usuario>

    fun obterFiltroFornecedores(): List<ReciboTabelaService.Fornecedor>

}