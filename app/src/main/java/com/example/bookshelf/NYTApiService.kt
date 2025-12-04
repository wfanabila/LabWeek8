package com.example.bookshelf

import com.example.bookshelf.model.NYTResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.nytimes.com/svc/books/v3/"

interface NYTApiService {
    @GET("lists/current/hardcover-fiction.json")
    suspend fun getBooks(
        @Query("api-key") apiKey: String = BuildConfig.NYT_API_KEY
    ): NYTResponse
}

object NYTApi {
    val retrofitService: NYTApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NYTApiService::class.java)
    }
}