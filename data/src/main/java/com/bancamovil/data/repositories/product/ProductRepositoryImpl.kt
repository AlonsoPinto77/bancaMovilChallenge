package com.bancamovil.data.repositories.product

import com.bancamovil.data.network.Api
import com.bancamovil.domain.interactors.product.Product
import com.bancamovil.domain.interactors.product.ProductRepository
import com.bancamovil.domain.interactors.product.ProductRequest

class ProductRepositoryImpl(private val api: Api) : ProductRepository {
    override suspend fun getProducts(productsRequest: ProductRequest): List<Product> {
        return try{
            var productsList : MutableList<Product> = arrayListOf()
            if(productsRequest.Count == 1){
                val result = api.getProductsList(productsRequest).data
                for(product in result){
                    productsList.add(product.mapToDomainModel())
                }
            } else{
                val result = api.getProductsListAdd(productsRequest).data
                for(product in result){
                    productsList.add(product.mapToDomainModel())
                }
            }
            productsList as List<Product>
        } catch (e: Exception){
            throw Exception(e.message)
        }
    }

}