package com.github.ozaru.eform.api.application.controller

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("verificar-permissoes")
@RestController
@Tag(name = "Verificacao de permissoes")
class VerificarPermissaoController {

    @PostMapping
    fun verificarPermissoes(
        @RequestBody permissoes: List<String>,
        authentication: Authentication
    ): List<Permissao> {
        return permissoes.map { permissao ->
            val auth = authentication.authorities.find { authority ->
                authority.authority == "ROLE_${permissao}"
            }
            Permissao(
                nome = permissao,
                existe = auth != null
            )
        }
    }

    data class Permissao(
        val nome: String,
        val existe: Boolean
    )

}