package com.bancamovil.data.network

import com.bancamovil.data.repositories.product.ProductEntity
import com.bancamovil.domain.interactors.login.Login
import com.bancamovil.domain.interactors.login.LoginRequest
import com.bancamovil.domain.interactors.product.ProductRequest
import retrofit2.http.Body
import retrofit2.http.GET

interface Api {
    @GET("login")
    suspend fun login(@Body request: LoginRequest): ApiResponse<Login>

    @GET("faillogin")
    suspend fun failedLogin(@Body request: LoginRequest): ApiResponse<String>

    @GET("products")
    suspend fun getProductsList(@Body request: ProductRequest): ApiResponse<List<ProductEntity>>

    @GET("productsNew")
    suspend fun getNewProductsList(@Body request: ProductRequest): ApiResponse<List<ProductEntity>>
}