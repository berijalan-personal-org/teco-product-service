package com.technocoffee.core.productservice.domain.dto.response

data class ResDetailProductDto(
    val id: Int,
    val name: String,
    val price: Double,
    val stock: Int,
    val categoryId: Int?,
    val categoryName: String?
)
