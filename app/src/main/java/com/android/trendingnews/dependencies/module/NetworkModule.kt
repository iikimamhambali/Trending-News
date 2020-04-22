package com.android.trendingnews.dependencies.module

import com.android.trendingnews.R
import com.android.trendingnews.data.factory.LiveDataCallAdapterFactory
import com.android.trendingnews.data.factory.NetworkServiceFactory
import com.android.trendingnews.data.network.NewsService
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single { NetworkServiceFactory.makeClientService(get(), get()) }

    single { NetworkServiceFactory.makeLoggingInterceptor() }

    single { NetworkServiceFactory.makeCache(get()) }

    single { NetworkServiceFactory.makeGson() }

    single(named("RetrofitMovie")) {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(get<OkHttpClient>(named("general_client")))
            .baseUrl(androidContext().getString(R.string.server_url) + "/")
            .build()
    }
    single { get<Retrofit>(named("RetrofitMovie")).create(NewsService::class.java) }
}