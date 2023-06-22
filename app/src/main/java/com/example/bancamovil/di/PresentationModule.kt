package com.example.bancamovil.di

import com.example.bancamovil.ui.login.LoginViewModel
import com.example.bancamovil.ui.products.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel{ProductsViewModel(get())}
}