package com.bancamovil.data.network

import com.bancamovil.data.repositories.product.ProductEntity
import com.bancamovil.domain.interactors.login.Login
import com.bancamovil.domain.interactors.login.LoginRequest
import com.bancamovil.domain.interactors.product.ProductRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): ApiResponse<String>

    @POST("products")
    suspend fun getProductsList(@Body request: ProductRequest): ApiResponse<List<ProductEntity>>


}