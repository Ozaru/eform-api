package com.github.ozaru.eform.api.repository.entity

import javax.persistence.*

@Entity
@Table(name = "modelo")
data class Modelo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,
    @Column(name = "nome")
    var nome: String,
    @Column(name = "ativo")
    var ativo: Boolean

)
