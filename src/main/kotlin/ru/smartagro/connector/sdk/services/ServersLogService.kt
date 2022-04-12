package ru.smartagro.connector.sdk.services

import io.vertx.core.buffer.Buffer
import io.vertx.core.json.JsonObject

interface ServersLogService {

    suspend fun logIncomingMessage(
        message: String,
        ident: String?,
        localPort: Int?,
        remotePort: Int?,
        remoteAddress: String?,
        protocol: String
    )

    suspend fun logIncomingBytes(
        message: Buffer,
        ident: String?,
        localPort: Int?,
        remotePort: Int?,
        remoteAddress: String?,
        protocol: String
    )

    suspend fun logAuth(
        message: String?,
        ident: String?,
        localPort: Int,
        remotePort: Int,
        remoteAddress: String?,
        protocol: String
    )

    suspend fun logAuthSuccces(
        message: String?,
        ident: String?,
        localPort: Int,
        remotePort: Int,
        remoteAddress: String?,
        protocol: String
    )

    suspend fun logAuthFailed(
        message: String?,
        ident: String?,
        localPort: Int,
        remotePort: Int,
        remoteAddress: String?,
        protocol: String
    )

    suspend fun logSaveMessage(
        savedMessages: List<JsonObject>,
        ident: String?,
        localPort: Int?,
        remotePort: Int?,
        remoteAddress: String?,
        protocol: String
    )

    suspend fun logSaveFailed(
        savedMessages: List<JsonObject>,
        ident: String?,
        localPort: Int?,
        remotePort: Int?,
        remoteAddress: String?,
        exception: Exception,
        protocol: String
    )

    suspend fun logParseFailed(
        message: String,
        ident: String?,
        localPort: Int?,
        remotePort: Int?,
        remoteAddress: String?,
        exception: Exception,
        protocol: String
    )

    suspend fun logResponse(
        ident: String?,
        localPort: Int,
        remotePort: Int,
        remoteAddress: String?,
        response: String,
        protocol: String
    )

    suspend fun logOnConnect(
        localPort: Int,
        remotePort: Int,
        remoteAddress: String?,
        protocol: String
    )

    suspend fun logOnClose(
        localPort: Int,
        remotePort: Int,
        remoteAddress: String?,
        protocol: String
    )
}