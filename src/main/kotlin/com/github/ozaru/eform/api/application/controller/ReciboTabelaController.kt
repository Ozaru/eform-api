package com.github.ozaru.eform.api.application.controller

import com.github.ozaru.eform.api.domain.enums.ReciboStatusEnum
import com.github.ozaru.eform.api.domain.service.ReciboTabelaService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.annotation.security.RolesAllowed


@RequestMapping("recibo-tabela")
@RestController
@Tag(name = "Tabela de recibos")
class ReciboTabelaController(
    private val reciboTabelaService: ReciboTabelaService
) {

    @GetMapping
    @RolesAllowed("recibo_tabela-abrir")
    fun obterTabela(
        @RequestParam(required = false) id: Long?,
        @RequestParam(required = false) usuarioId: Long?,
        @RequestParam(required = false) fornecedorId: Long?,
        @RequestParam(required = false) dataInicial: LocalDateTime?,
        @RequestParam(required = false) dataFinal: LocalDateTime?,
        @RequestParam(required = false) valorInicial: BigDecimal?,
        @RequestParam(required = false) valorFinal: BigDecimal?,
        @RequestParam(required = false) status: ReciboStatusEnum?,
        pageable: Pageable
    ): Page<ReciboTabelaService.Recibo> {
        return reciboTabelaService.obterTabela(
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

    @GetMapping("usuarios-filtro")
    @RolesAllowed("recibo_tabela-abrir")
    fun obterFiltroUsuarios(): List<ReciboTabelaService.Usuario> {
        return reciboTabelaService.obterFiltroUsuarios()
    }

    @GetMapping("fornecedores-filtro")
    @RolesAllowed("recibo_tabela-abrir")
    fun obterFiltroFornecedores(): List<ReciboTabelaService.Fornecedor> {
        return reciboTabelaService.obterFiltroFornecedores()
    }

    @GetMapping("status-filtro")
    @RolesAllowed("recibo_tabela-abrir")
    fun obterFiltroStatus(): List<ReciboTabelaService.Status> {
        return reciboTabelaService.obterFiltroStatus()
    }

}