package com.example.bancamovil.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bancamovil.domain.common.Resource
import com.bancamovil.domain.interactors.login.Login
import com.bancamovil.domain.interactors.login.LoginAccess
import com.bancamovil.domain.interactors.login.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel(private val useCase : LoginAccess) : ViewModel() {

    val viewState = MutableLiveData<Resource<Login>>()

    fun login(loginRequest: LoginRequest){
        viewModelScope.launch {
            runCatching {
                viewState.postValue(Resource.Loading(true))
                useCase.invoke(loginRequest)
            }.onSuccess {
                viewState.postValue(Resource.Success(it))
            }.onFailure {
                viewState.postValue(Resource.Error(it.message.toString()))
            }
        }
    }
}