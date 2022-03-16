package com.github.ozaru.eform.api.domain.service

import com.github.ozaru.eform.api.domain.enums.ReciboStatusEnum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.math.BigDecimal
import java.time.LocalDateTime

interface ReciboTabelaService {

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
    ): Page<Recibo>

    fun obterFiltroUsuarios(): List<Usuario>

    fun obterFiltroFornecedores(): List<Fornecedor>

    fun obterFiltroStatus(): List<Status>

    data class Recibo(
        val id: Long,
        val data: LocalDateTime,
        val usuarioNome: String,
        val fornecedorNome: String,
        val valor: BigDecimal,
        val status: String
    )

    data class Usuario(
        val id: String,
        var nome: String
    )

    data class Fornecedor(
        val id: Long,
        var nome: String
    )

    data class Status(
        var nome: String,
        var texto: String
    )

}