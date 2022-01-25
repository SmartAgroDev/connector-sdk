package ru.smartagro.connector.sdk.annotation

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Protocol(
    val name: String,
    val clientName: String,
    val icon: String,
    val io: String
)