package com.bancamovil.domain.di

import com.bancamovil.domain.interactors.login.Login
import com.bancamovil.domain.interactors.login.LoginImpl
import com.bancamovil.domain.interactors.product.GetProductList
import com.bancamovil.domain.interactors.product.GetProductListImpl
import org.koin.dsl.module

val interactionModule = module {
    factory<Login> { LoginImpl(get()) }
    factory<GetProductList> { GetProductListImpl(get()) }
}