package com.bancamovil.domain.interactors.product

interface ProductRepository {
    suspend fun getProducts(productsRequest: ProductRequest) : List<Product>
}