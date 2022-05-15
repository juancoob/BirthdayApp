package com.example.birthdayapp.server

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val dob: Dob,
    val name: Name
)