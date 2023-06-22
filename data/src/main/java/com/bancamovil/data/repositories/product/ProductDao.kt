package com.bancamovil.data.repositories.product

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Query("select * from product")
    fun getProducts(): LiveData<List<ProductEntity>>

    @Insert
    fun insert(productEntity: ProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMultiple(product: List<ProductEntity>)
}