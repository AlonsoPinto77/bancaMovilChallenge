package com.bancamovil.domain.interactors.product

interface GetProductList{
    suspend operator fun invoke(productRequest: ProductRequest) : List<Product>
}

class GetProductListImpl(private val productRepository: ProductRepository) : GetProductList{
    override suspend fun invoke(productRequest: ProductRequest): List<Product> {
        return productRepository.getProducts(productRequest)
    }
}