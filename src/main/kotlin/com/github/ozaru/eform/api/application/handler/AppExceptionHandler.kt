package com.github.ozaru.eform.api.application.handler

import com.github.ozaru.eform.api.domain.exception.AppException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class AppExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(AppException::class)])
    fun handleAppException(exception: AppException): ResponseEntity<String> {
        return ResponseEntity(exception.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [(Exception::class)])
    fun handleException(exception: Exception): ResponseEntity<String> {
        var codigo = UUID.randomUUID().toString()
        return ResponseEntity("erro desconhecido - cod: $codigo", HttpStatus.INTERNAL_SERVER_ERROR)
    }

}