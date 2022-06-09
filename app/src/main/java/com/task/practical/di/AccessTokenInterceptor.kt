package com.task.practical.di

import android.content.Context
import com.task.practical.data.remote.ApiConstants
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AccessTokenInterceptor(
    @ApplicationContext private val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        setAuthHeader(builder)

        val newRequest = builder.build()
        return chain.proceed(newRequest)
    }

    /**
     * set header
     */
    private fun setAuthHeader(builder: Request.Builder) {
        builder.addHeader(ApiConstants.SOURCE_KEY, ApiConstants.SOURCE_VALUE)
    }
}
