package com.globits.mita.di

import android.content.Context
import com.globits.mita.data.network.*
import com.globits.mita.data.repository.*
import dagger.Module
import dagger.Provides

@Module
object NetWorkModule {

    @Provides
    fun providerRemoteDateSource(): RemoteDataSource = RemoteDataSource()


    @Provides
    fun providerUserPreferences(context: Context): SessionManager= SessionManager(context)

    @Provides
    fun providerAuthApi(
        remoteDataSource: RemoteDataSource,
        context: Context
    ) = remoteDataSource.buildApiAuth(AuthApi::class.java, context)

    @Provides
    fun providerAuthRepository(
        userPreferences: SessionManager,
        api: AuthApi
    ) :AuthRepository=AuthRepository(api,userPreferences)

    @Provides
    fun providerUserApi(
        remoteDataSource: RemoteDataSource,
        context: Context
    ) = remoteDataSource.buildApi(UserApi::class.java, context)
    @Provides
    fun providerUserRepository(
        api: UserApi
    ) : UserRepository =UserRepository(api)

}