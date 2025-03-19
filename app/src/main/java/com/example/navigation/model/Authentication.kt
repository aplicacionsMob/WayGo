package com.example.navigation.model

data class Authentication(
    val email: String,
    val password: String
) {
    fun login() {
        // Simulació d'autenticació
    }

    fun logout() {
        // Tancar sessió
    }

    fun resetPassword() {
        // Enviar email de reset de contrasenya
    }
}
