package com.bancamovil.domain.di

import com.bancamovil.domain.interactors.login.LoginAccess
import com.bancamovil.domain.interactors.login.LoginAccessImpl
import com.bancamovil.domain.interactors.product.GetProductList
import com.bancamovil.domain.interactors.product.GetProductListImpl
import org.koin.dsl.module

val interactionModule = module {
    factory<LoginAccess> { LoginAccessImpl(get()) }
    factory<GetProductList> { GetProductListImpl(get()) }
}