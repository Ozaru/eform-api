package com.github.ozaru.eform.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}
