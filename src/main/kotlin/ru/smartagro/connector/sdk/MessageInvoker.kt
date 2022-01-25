package ru.smartagro.connector.sdk

import io.vertx.core.buffer.Buffer
import io.vertx.core.net.NetSocket

interface MessageInvoker {

    fun consumeBytesFrom(
        socket: NetSocket,
        onBytes: ((Buffer) -> Unit)? = null,
        onMessage: suspend (Buffer) -> Unit)
}