package com.example.bancamovil

import android.app.Application
import com.bancamovil.data.di.databaseModule
import com.bancamovil.data.di.networkModule
import com.bancamovil.data.di.repositoryModule
import com.bancamovil.domain.di.interactionModule
import com.example.bancamovil.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    private val coreModules = listOf(interactionModule)
    private val dataModules = listOf(databaseModule, networkModule, repositoryModule)
    private val appModules = listOf(presentationModule)

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(coreModules + dataModules + appModules)
        }
    }
}