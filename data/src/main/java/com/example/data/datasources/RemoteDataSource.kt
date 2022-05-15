package com.example.data.datasources

import com.example.domain.BirthDayUser

interface RemoteDataSource {
    suspend fun fetchBirthdayUsers(results: String, seed: String, inc: String): List<BirthDayUser>
}