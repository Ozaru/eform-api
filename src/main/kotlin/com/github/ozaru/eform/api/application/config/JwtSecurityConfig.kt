package com.github.ozaru.eform.api.application.config

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter

import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter

@EnableWebSecurity
@EnableGlobalMethodSecurity(
    jsr250Enabled = true
)
class JWTSecurityConfig : WebSecurityConfigurerAdapter() {

    private fun jwtAuthenticationConverter(): JwtAuthenticationConverter {
        val jwtGrantedAuthoritiesConverter = JwtGrantedAuthoritiesConverter()
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("roles")
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix("ROLE_")
        val jwtAuthenticationConverter = JwtAuthenticationConverter()
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter)
        return jwtAuthenticationConverter
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .anyRequest().authenticated()
            .and().oauth2ResourceServer().jwt()
            .jwtAuthenticationConverter(jwtAuthenticationConverter())

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }

}