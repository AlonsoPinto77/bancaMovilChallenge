package com.example.bancamovil

import android.app.Application
import com.bancamovil.data.di.databaseModule
import com.bancamovil.data.di.networkModule
import com.bancamovil.data.di.repositoryModule
import com.bancamovil.domain.di.interactionModule
import com.example.bancamovil.di.coreModules
import com.example.bancamovil.di.dataModules
import com.example.bancamovil.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(coreModules, dataModules, presentationModule )
            androidLogger()
        }
    }
}