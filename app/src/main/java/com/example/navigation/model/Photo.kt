package com.example.navigation.model


data class Photo(
    val id: String,
    var url: String,
    var description: String
) {
    fun uploadPhoto(newUrl: String, newDescription: String) {
        url = newUrl
        description = newDescription
    }
}
