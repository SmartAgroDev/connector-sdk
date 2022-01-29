package ru.smartagro.connector.sdk

import io.vertx.core.buffer.Buffer
import io.vertx.core.net.NetSocket

interface MessageInvoker {

    fun consumeBytesFrom(
        socket: NetSocket,
        onBytes: suspend ((Buffer) -> Unit) = {},
        onMessage: suspend (Buffer) -> Unit)
}