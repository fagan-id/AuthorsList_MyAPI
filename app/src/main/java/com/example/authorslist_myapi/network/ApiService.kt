package com.example.authorslist_myapi.network

import com.example.authorslist_myapi.model.Authors
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("authors")
    fun getAllAuthors(): Call<List<Authors>>
}