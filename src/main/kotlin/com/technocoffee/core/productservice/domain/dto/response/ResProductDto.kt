package com.technocoffee.core.productservice.domain.dto.response

data class ResProductDto(
    val id: Int,
    val name: String,
    val price: Double,
    val category: String? = null
)
