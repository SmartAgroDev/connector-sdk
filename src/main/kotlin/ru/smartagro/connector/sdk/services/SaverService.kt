package ru.smartagro.connector.sdk.services

import io.vertx.core.json.JsonObject

interface SaverService {

    suspend fun save(messages: List<JsonObject>)
}