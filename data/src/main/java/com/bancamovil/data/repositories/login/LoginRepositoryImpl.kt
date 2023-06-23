package com.bancamovil.data.repositories.login

import com.bancamovil.data.network.Api
import com.bancamovil.domain.interactors.login.Login
import com.bancamovil.domain.interactors.login.LoginRepository
import com.bancamovil.domain.interactors.login.LoginRequest

class LoginRepositoryImpl(private val api: Api) : LoginRepository {
    override suspend fun login(loginRequest: LoginRequest): String {
        return try{
            if(loginRequest.Password=="test1234" || loginRequest.UserDni==12345678)
                api.login(loginRequest).data
            else
                api.loginFail(loginRequest).data
        }catch (e: Exception){
            throw Exception(e.message)
        }

    }
}