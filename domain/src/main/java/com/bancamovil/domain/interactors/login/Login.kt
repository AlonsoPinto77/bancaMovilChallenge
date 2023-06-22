package com.bancamovil.domain.interactors.login

interface Login {
    suspend operator fun invoke(loginRequest: LoginRequest): String
}

class LoginImpl(private val loginRepository: LoginRepository) : Login {
    override suspend fun invoke(loginRequest: LoginRequest): String {
        return loginRepository.login(loginRequest)
    }
}
