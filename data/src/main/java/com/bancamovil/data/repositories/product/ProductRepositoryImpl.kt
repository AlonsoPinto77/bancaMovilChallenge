package com.bancamovil.data.repositories.product

import com.bancamovil.data.network.Api
import com.bancamovil.domain.interactors.product.Product
import com.bancamovil.domain.interactors.product.ProductRepository
import com.bancamovil.domain.interactors.product.ProductRequest

class ProductRepositoryImpl(private val api: Api, private val productsDao: ProductDao) : ProductRepository {
    override suspend fun getProducts(productsRequest: ProductRequest): List<Product> {
        return try{
            val result = api.getProductsList(productsRequest).data
            var productsList : MutableList<Product> = arrayListOf()
            for(product in result){
                productsList.add(product.mapToDomainModel())
            }
            productsList as List<Product>
        } catch (e: Exception){
            throw Exception(e.message)
        }
    }

}