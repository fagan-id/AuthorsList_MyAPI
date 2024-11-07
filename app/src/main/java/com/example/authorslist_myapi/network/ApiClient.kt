package com.example.authorslist_myapi.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getInstance() : ApiService {
        val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()

        val builder = Retrofit.Builder()
            .baseUrl("https://thetestrequest.com")  // hanya mengambil BaseURL saja tanpa path spesifik
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
        return builder.create(ApiService::class.java)

    }
}