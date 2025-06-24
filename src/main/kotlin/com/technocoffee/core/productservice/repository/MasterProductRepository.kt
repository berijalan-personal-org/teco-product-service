package com.technocoffee.core.productservice.repository

import com.technocoffee.core.productservice.domain.entity.MasterProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MasterProductRepository: JpaRepository<MasterProductEntity, Int> {
    @Query("""
        SELECT p FROM MasterProductEntity p
        WHERE p.category.id = :categoryId
    """)
    fun findByCategoryId(categoryId: Int): List<MasterProductEntity>
}