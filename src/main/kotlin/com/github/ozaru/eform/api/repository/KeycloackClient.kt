package com.github.ozaru.eform.api.repository

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import java.net.URI


@FeignClient(
    value = "keycloackClient",
    url = "\${spring.security.oauth2.resourceserver.jwt.issuer-uri}"
)
interface KeycloackClient {

    @PostMapping(
        value = ["protocol/openid-connect/token"],
        consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE]
    )
    fun getClientToken(
        tokenForm: Map<String, Any>
    ): Token

    @GetMapping("users")
    fun getUsers(
        baseUrl: URI,
        @RequestHeader("Authorization") bearerToken: String
    ): List<Usuario>

    data class Usuario(
        val id: String,
        val username: String
    )

    data class Token(
        @JsonProperty("access_token")
        val accessToken: String
    )

}