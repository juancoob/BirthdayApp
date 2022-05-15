package com.example.birthdayapp.server

import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("api/")
    suspend fun fetchBirthdayUsers(
        @Query("results") results: String,
        @Query("seed") seed: String,
        @Query("inc") inc: String
    ): RemoteResult
}