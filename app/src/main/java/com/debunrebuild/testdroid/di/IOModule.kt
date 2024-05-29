package com.debunrebuild.testdroid.di

import com.debunrebuild.testdroid.DemoAPI
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object IOModule {

    @Provides
    @Singleton
    fun provideApiService() : DemoAPI {
        val okHttpClient = OkHttpClient.Builder().build()
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson)).baseUrl("")
            .build()
        return retrofit.create(DemoAPI::class.java)
    }


}