package com.uniumuniu.simplestreaming.di

import com.uniumuniu.simplestreaming.common.Constants
import com.uniumuniu.simplestreaming.data.remote.IStreamingServiceApi
import com.uniumuniu.simplestreaming.data.repository.EventsRepository
import com.uniumuniu.simplestreaming.domain.repository.IEventsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideStreamingServiceApi(): IStreamingServiceApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IStreamingServiceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideEventsRepository(api: IStreamingServiceApi): IEventsRepository {
        return EventsRepository(api)
    }
}