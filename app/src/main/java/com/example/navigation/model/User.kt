package com.example.navigation.model

data class User(
    val id: String,
    val name: String,
    val email: String,
    val phoneNumber: String?,
    val profilePictureUrl: String?,
    val bio: String?,
    val followers: Int = 0,
    val following: Int = 0,
    val uploadedRoutes: Int = 0,
    val totalLikes: Int = 0
)
