package com.technocoffee.core.productservice.repository

import com.technocoffee.core.productservice.domain.entity.MasterCategoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MasterCategoryRepository: JpaRepository<MasterCategoryEntity, Int> {
}