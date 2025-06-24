package com.technocoffee.core.productservice.service

import com.technocoffee.core.productservice.domain.dto.response.ResDetailProductDto
import com.technocoffee.core.productservice.domain.dto.response.ResProductDto

interface MasterProductService {
    fun getAllProduct(): List<ResProductDto>
    fun getProductById(id: Int): ResDetailProductDto
    fun getProductByCategory(categoryId: Int): List<ResProductDto>
}