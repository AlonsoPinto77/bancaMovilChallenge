package com.bancamovil.data.di

import com.bancamovil.data.repositories.login.LoginRepositoryImpl
import com.bancamovil.data.repositories.product.ProductRepositoryImpl
import com.bancamovil.data.utils.LocalStorage
import com.bancamovil.domain.interactors.login.LoginRepository
import com.bancamovil.domain.interactors.product.ProductRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single { LocalStorage(androidContext()) }

    factory<ProductRepository>{ProductRepositoryImpl(get()) }
    factory<LoginRepository>{LoginRepositoryImpl(get())}
}