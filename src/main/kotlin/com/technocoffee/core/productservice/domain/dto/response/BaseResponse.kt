package com.technocoffee.core.productservice.domain.dto.response

import java.io.Serializable
import java.util.*

data class BaseResponse<T>(
    val reqId: UUID? = UUID.randomUUID(),
    val status: String = "T",
    val message: String? = "Berhasil",
    val error: Any? = null,
    val data: T? = null,
): Serializable {
    companion object {
        private const val serialVersionUID: Long = -4166494507662335449L
    }
}
