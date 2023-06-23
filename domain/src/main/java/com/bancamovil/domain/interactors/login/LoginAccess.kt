package com.bancamovil.domain.interactors.login

interface LoginAccess {
    suspend operator fun invoke(loginRequest: LoginRequest): String
}

class LoginAccessImpl(private val loginRepository: LoginRepository) : LoginAccess {
    override suspend fun invoke(loginRequest: LoginRequest): String {
        return loginRepository.login(loginRequest)
    }
}
