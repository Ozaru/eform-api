package com.github.ozaru.eform.api.repository

import com.github.ozaru.eform.api.repository.entity.Fornecedor
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FornecedorDAO : JpaRepository<Fornecedor, Long> {

    fun findAllByNomeContainingIgnoreCaseAndAtivoTrue(nome: String, pageable: Pageable): Page<Fornecedor>
    fun findAllByNomeContainingIgnoreCase(nome: String, pageable: Pageable): Page<Fornecedor>

}