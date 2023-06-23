package com.example.bancamovil.di

import com.bancamovil.data.di.databaseModule
import com.bancamovil.data.di.networkModule
import com.bancamovil.data.di.repositoryModule
import com.bancamovil.domain.di.interactionModule
import com.example.bancamovil.ui.login.LoginViewModel
import com.example.bancamovil.ui.products.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module

val coreModules = module {
    includes(interactionModule)
}

val dataModules = module {
    includes(networkModule, repositoryModule)
}

val presentationModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { ProductsViewModel(get()) }
}