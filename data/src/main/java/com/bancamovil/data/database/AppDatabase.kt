package com.bancamovil.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bancamovil.data.repositories.product.ProductDao
import com.bancamovil.data.repositories.product.ProductEntity

@Database(
    entities = [ProductEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun productDao() : ProductDao
}