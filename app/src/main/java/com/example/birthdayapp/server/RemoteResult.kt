package com.example.birthdayapp.server

import kotlinx.serialization.Serializable

@Serializable
data class RemoteResult(
    val results: List<Result>
)