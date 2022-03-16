package com.github.ozaru.eform.api.domain.util

import com.google.common.hash.Hashing
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets

@Component
class HashEncoderUtil {

    fun encode(text: String): String {
        return Hashing.sha256()
            .hashString(text, StandardCharsets.UTF_8)
            .toString()
    }

}