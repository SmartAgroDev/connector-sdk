package ru.smartagro.connector.sdk.models

import io.vertx.core.buffer.Buffer
import io.vertx.core.json.JsonObject

class ParseResult(
    val messages: List<JsonObject>,
    val response: Buffer
)