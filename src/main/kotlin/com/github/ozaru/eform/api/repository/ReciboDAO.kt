package com.github.ozaru.eform.api.repository

import com.github.ozaru.eform.api.repository.entity.Recibo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReciboDAO : JpaRepository<Recibo, Long>