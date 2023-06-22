package com.bancamovil.data.di

import androidx.room.Room
import com.bancamovil.data.common.DB_NAME
import com.bancamovil.data.database.AppDatabase
import org.koin.dsl.module
import org.koin.android.ext.koin.androidApplication

val databaseModule = module{
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration().build()
    }

    single { get<AppDatabase>().productDao() }
}