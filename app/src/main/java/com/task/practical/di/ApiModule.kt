package com.task.practical.di

import android.content.Context
import com.task.practical.BuildConfig
import com.task.practical.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TOKEN_AUTHENTICATOR: String = "TOKEN_AUTHENTICATOR"
private const val ACCESS_TOKEN_INTERCEPTOR: String = "ACCESS_TOKEN_INTERCEPTOR"
private const val HTTP_LOGGING_INTERCEPTOR: String = "HTTP_LOGGING_INTERCEPTOR"
private const val OKHTTP_CLIENT = "OKHTTP_CLIENT"
private const val CACHE_SIZE: Long = 10 * 1024 * 1024 // 10 MB
private const val NETWORK_CALL_TIMEOUT: Long = 1 // Minute

/**
 * Provides remote APIs dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    @Named(HTTP_LOGGING_INTERCEPTOR)
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
    }

    @Singleton
    @Provides
    @Named(ACCESS_TOKEN_INTERCEPTOR)
    fun provideAccessToken(
        @ApplicationContext context: Context
    ): AccessTokenInterceptor {
        return AccessTokenInterceptor(context)
    }

    @Provides
    @Named(OKHTTP_CLIENT)
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        @Named(HTTP_LOGGING_INTERCEPTOR) httpLoggingInterceptor: HttpLoggingInterceptor,
        @Named(ACCESS_TOKEN_INTERCEPTOR) accessTokenInterceptor: AccessTokenInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .cache(Cache(context.cacheDir, CACHE_SIZE))
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(accessTokenInterceptor)
        .readTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.MINUTES)
        .writeTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.MINUTES)
        .build()

    @Provides
    fun provideRetrofit(
        @Named(OKHTTP_CLIENT) okHttpClient: OkHttpClient
    ): ApiService = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)


}
