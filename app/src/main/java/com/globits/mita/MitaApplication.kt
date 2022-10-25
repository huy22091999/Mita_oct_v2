package com.globits.mita

import android.app.Application
import com.globits.mita.di.DaggerMitaComponent
import com.globits.mita.di.MitaComponent
import timber.log.Timber


open class MitaApplication : Application() {
    val mitaComponent: MitaComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): MitaComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerMitaComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()

        mitaComponent.inject(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}

