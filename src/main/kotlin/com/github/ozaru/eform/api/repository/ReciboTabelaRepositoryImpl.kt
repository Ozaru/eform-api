package com.github.ozaru.eform.api.repository

import com.github.ozaru.eform.api.domain.enums.ReciboStatusEnum
import com.github.ozaru.eform.api.domain.repository.ReciboTabelaRepository
import com.github.ozaru.eform.api.domain.service.ReciboTabelaService
import com.github.ozaru.eform.api.repository.entity.Recibo
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.net.URI
import java.time.LocalDateTime
import javax.persistence.EntityManager

@Component
class ReciboTabelaRepositoryImpl(
    private val keycloackClient: KeycloackClient,
    private val fornecedorDAO: FornecedorDAO,
    private val entityManager: EntityManager,
    @Value("\${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private val issuerUri: String,
    @Value("\${custom.sso.client-admin-id}")
    private val clientAdminId: String,
    @Value("\${custom.sso.client-user-name}")
    private val username: String,
    @Value("\${custom.sso.client-user-pass}")
    private val password: String,
) : ReciboTabelaRepository {

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
        val query = StringBuilder()
        query.append("select t from Recibo t where 1 = 1")
        val params = HashMap<String, Any>()
        if (id != null) {
            query.append(" and id = :id")
            params.set("id", id)
        }
        if (usuarioId != null) {
            query.append(" and t.usuarioId = :usuarioId")
            params.set("usuarioId", usuarioId)
        }
        if (fornecedorId != null) {
            query.append(" and t.fornecedor.id = :fornecedorId")
            params.set("fornecedorId", fornecedorId)
        }
        if (dataInicial != null) {
            query.append(" and t.data >= :dataInicial")
            params.set("dataInicial", dataInicial)
        }
        if (dataFinal != null) {
            query.append(" and t.data <= :dataFinal")
            params.set("dataFinal", dataFinal)
        }
        if (valorInicial != null) {
            query.append(" and t.valor >= :valorInicial")
            params.set("valorInicial", valorInicial)
        }
        if (valorFinal != null) {
            query.append(" and t.valor <= :valorFinal")
            params.set("valorFinal", valorFinal)
        }
        if (status != null) {
            query.append(" and t.status = :status")
            params.set("status", status)
        }
        val typedQuery = entityManager.createQuery(query.toString(), Recibo::class.java)
        params.entries.forEach { param ->
            typedQuery.setParameter(param.key, param.value)
        }
        return typedQuery.resultList.map { recibo ->
            ReciboTabelaService.Recibo(
                id = recibo.id,
                data = recibo.data,
                usuarioNome = recibo.usuarioNome,
                fornecedorNome = recibo.fornecedor.nome,
                valor = recibo.valor,
                status = recibo.status.texto
            )
        }.let { recibos ->
            PageImpl<ReciboTabelaService.Recibo>(recibos)
        }
    }

    override fun obterFiltroUsuarios(): List<ReciboTabelaService.Usuario> {
        val form = HashMap<String, Any>()
        form.set("client_id", this.clientAdminId)
        form.set("username", this.username)
        form.set("password", this.password)
        form.set("grant_type", "password")
        val url = URI.create(issuerUri.replace("/auth/realms/", "/auth/admin/realms/"))
        return keycloackClient.getClientToken(form).let { token ->
            keycloackClient.getUsers(url, "Bearer ${token.accessToken}").map { user ->
                ReciboTabelaService.Usuario(
                    id = user.id,
                    nome = user.username
                )
            }
        }

    }

    override fun obterFiltroFornecedores(): List<ReciboTabelaService.Fornecedor> {
        return fornecedorDAO.findAll().map { fornecedor ->
            ReciboTabelaService.Fornecedor(
                id = fornecedor.id,
                nome = fornecedor.nome
            )
        }
    }


}