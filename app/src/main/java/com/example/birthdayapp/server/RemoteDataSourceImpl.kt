package com.example.birthdayapp.server

import com.example.data.datasources.RemoteDataSource
import com.example.domain.BirthDayUser
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val remoteService: RemoteService
) : RemoteDataSource {

    override suspend fun fetchBirthdayUsers(
        results: String,
        seed: String,
        inc: String
    ): List<BirthDayUser> =
        remoteService.fetchBirthdayUsers(results, seed, inc).results.toDomainModel()

    private fun List<Result>.toDomainModel() = map { it.toDomainModel() }

    private fun Result.toDomainModel() = BirthDayUser(
        initials = getInitials(name),
        name = addName(name),
        yearsText = dob.age,
        birthdayDate = dob.date
    )

    private fun getInitials(name: Name): String =
        name.first.first().toString() + name.last.first().toString()

    private fun addName(name: Name): String = "${name.first} ${name.last}"
}