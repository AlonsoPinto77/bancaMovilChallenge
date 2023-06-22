package com.bancamovil.domain.common

import kotlin.Result

interface UseCase<T : Any, R : Any> {

    suspend operator fun invoke(param: T): Result<R>

    suspend operator fun invoke(params: List<T>): Result<List<R>>
}