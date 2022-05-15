package com.example.data.repositories

import com.example.data.datasources.RemoteDataSource
import com.example.domain.BirthDayUser
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun fetchBirthdayUsers(results: String, seed: String, inc: String): List<BirthDayUser> =
        remoteDataSource.fetchBirthdayUsers(results, seed, inc)
}