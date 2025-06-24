package com.technocoffee.core.productservice.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "mst_products")
data class MasterProductEntity(
    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "name")
    val name: String,

    @Column(name = "price")
    val price: Double,

    @Column(name = "stock")
    val stock: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category")
    val category: MasterCategoryEntity?

): BaseEntity()
