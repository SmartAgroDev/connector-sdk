package ru.smartagro.connector.sdk.services

interface DeviceAuthService {

    suspend fun auth(ident: String): Boolean
}