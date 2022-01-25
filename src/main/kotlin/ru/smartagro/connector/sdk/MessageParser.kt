package ru.smartagro.connector.sdk

import io.vertx.core.buffer.Buffer
import ru.smartagro.connector.sdk.models.ParseResult

interface MessageParser {

    fun parse(message: Buffer): ParseResult

    fun invokeIdents(message: Buffer): List<String>
}