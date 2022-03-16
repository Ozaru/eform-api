package com.github.ozaru.eform.api.domain.enums

enum class ReciboStatusEnum(
    val texto: String
) {
    AGUARDANDO_ENVIO("Aguardando envio"),
    AGUARDANDO_APROVACAO("Aguardando aprovação"),
    CANCELADO_USUARIO("Cancelado pelo usuario"),
    CANCELADO_ADMIN("Cancelado pelo administrador"),
    FINALIZADO("Finalizado")
}