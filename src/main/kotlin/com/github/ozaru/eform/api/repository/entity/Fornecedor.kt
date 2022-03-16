package com.github.ozaru.eform.api.repository.entity

import javax.persistence.*

@Entity
@Table(name = "fornecedor")
data class Fornecedor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,
    @Column(name = "nome")
    val nome: String,
    @Column(name = "ativo")
    val ativo: Boolean

)
