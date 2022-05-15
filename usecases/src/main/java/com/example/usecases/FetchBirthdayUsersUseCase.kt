package com.example.usecases

import com.example.data.repositories.UserRepository
import com.example.domain.BirthDayUser
import javax.inject.Inject

class FetchBirthdayUsersUseCase @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(results: String, seed: String, inc: String): List<BirthDayUser> =
        repository.fetchBirthdayUsers(results, seed, inc)
}