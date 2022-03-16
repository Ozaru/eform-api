package com.github.ozaru.eform.api.repository

import com.github.ozaru.eform.api.repository.entity.Item
import com.github.ozaru.eform.api.repository.entity.Modelo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ModeloDAO : JpaRepository<Modelo, Long> {

    fun findAllByNomeContainingIgnoreCaseAndAtivoTrue(nome: String, pageable: Pageable): Page<Item>
    fun findAllByNomeContainingIgnoreCase(nome: String, pageable: Pageable): Page<Item>

}