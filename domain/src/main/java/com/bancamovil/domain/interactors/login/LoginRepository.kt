package com.bancamovil.domain.interactors.login

interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest) : Login
}