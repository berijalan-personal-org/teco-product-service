package com.technocoffee.core.productservice.controller

import com.technocoffee.core.productservice.domain.dto.response.BaseResponse
import com.technocoffee.core.productservice.domain.dto.response.ResDetailProductDto
import com.technocoffee.core.productservice.domain.dto.response.ResProductDto
import com.technocoffee.core.productservice.service.MasterProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/product")
class ProductController(
    private val masterProductService: MasterProductService
){
    @GetMapping("/all")
    fun getAllProduct(): ResponseEntity<BaseResponse<List<ResProductDto>>> {
        return ResponseEntity.ok(
            BaseResponse(
                data = masterProductService.getAllProduct()
            )
        )
    }

    @GetMapping("category/{id}")
    fun getProductByCategory(
        @PathVariable id: Int
    ): ResponseEntity<BaseResponse<List<ResProductDto>>> {
        return ResponseEntity.ok(
            BaseResponse(
                data = masterProductService.getProductByCategory(id)
            )
        )
    }

    @GetMapping("/{id}")
    fun getProductById(
        @PathVariable id: Int
    ): ResponseEntity<BaseResponse<ResDetailProductDto>?> {
        return ResponseEntity.ok(
            BaseResponse(
                data = masterProductService.getProductById(id)
            )
        )
    }
}