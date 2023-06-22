package com.example.bancamovil.ui.products

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bancamovil.domain.common.Resource
import com.bancamovil.domain.interactors.product.GetProductList
import com.bancamovil.domain.interactors.product.Product
import com.bancamovil.domain.interactors.product.ProductRequest
import kotlinx.coroutines.launch

class ProductsViewModel(private val useCase : GetProductList): ViewModel() {
    val viewState = MutableLiveData<Resource<List<Product>>>()

    fun getProducts(productRequest: ProductRequest){
        viewModelScope.launch {
            runCatching {
                useCase.invoke(productRequest)
            }.onSuccess {
                viewState.postValue(Resource.Success(it))
            }.onFailure {
                viewState.postValue(Resource.Error(it.message.toString()))
            }
        }
    }
}