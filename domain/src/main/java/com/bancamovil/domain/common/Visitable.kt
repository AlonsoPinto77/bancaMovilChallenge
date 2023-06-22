package com.bancamovil.domain.common

interface Visitable {
    fun type(typeFactory: TypeFactory): Int
}