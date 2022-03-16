package com.github.ozaru.eform.api.repository.entity

import com.github.ozaru.eform.api.domain.enums.ReciboStatusEnum
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "recibo")
data class Recibo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    val fornecedor: Fornecedor,
    @Column(name = "usuario_id")
    val usuarioId: String,
    @Column(name = "usuario_nome")
    val usuarioNome: String,
    @Column(name = "data")
    val data: LocalDateTime,
    @Column(name = "valor")
    val valor: BigDecimal,
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    val status: ReciboStatusEnum
)
