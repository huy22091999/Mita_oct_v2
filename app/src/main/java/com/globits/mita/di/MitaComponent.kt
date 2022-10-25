package com.globits.mita.di

import android.content.Context
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.globits.mita.MitaApplication
import com.globits.mita.ui.MainActivity
import com.globits.mita.ui.security.LoginActivity

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    ViewModelModule::class,
    FragmentModule::class,
    NetWorkModule::class
])
@Singleton
interface MitaComponent {
    fun inject(xCareApplication: MitaApplication)
    fun inject(mainActivity: MainActivity)
    fun inject(loginActivity: LoginActivity)
    fun fragmentFactory(): FragmentFactory
    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MitaComponent
    }
}