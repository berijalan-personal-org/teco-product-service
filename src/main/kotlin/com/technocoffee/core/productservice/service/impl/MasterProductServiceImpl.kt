package com.technocoffee.core.productservice.service.impl

import com.technocoffee.core.productservice.domain.dto.response.ResDetailProductDto
import com.technocoffee.core.productservice.domain.dto.response.ResProductDto
import com.technocoffee.core.productservice.exception.BadRequestException
import com.technocoffee.core.productservice.repository.MasterProductRepository
import com.technocoffee.core.productservice.service.MasterProductService
import org.springframework.stereotype.Service

@Service
class MasterProductServiceImpl(
    private val productRepository: MasterProductRepository
): MasterProductService {
    override fun getAllProduct(): List<ResProductDto> {
        val products = productRepository.findAll()
        val result = mutableListOf<ResProductDto>()

        products.forEach { product ->
            result.add(
                ResProductDto(
                    id = product.id,
                    name = product.name,
                    price = product.price,
                    category = product.category?.name
                )
            )
        }
        return result
    }

    override fun getProductById(id: Int): ResDetailProductDto {
        val product = productRepository.findById(id).orElseThrow {
            BadRequestException("Product with id $id not found")
        }
        return ResDetailProductDto(
            id = product.id,
            name = product.name,
            price = product.price,
            stock = product.stock,
            categoryId = product.category?.id,
            categoryName = product.category?.name
        )
    }

    override fun getProductByCategory(categoryId: Int): List<ResProductDto> {
        val products = productRepository.findByCategoryId(categoryId)
        val result = mutableListOf<ResProductDto>()

        products.forEach { product ->
            result.add(
                ResProductDto(
                    id = product.id,
                    name = product.name,
                    price = product.price,
                    category = product.category?.name
                )
            )
        }
        return result
    }
}