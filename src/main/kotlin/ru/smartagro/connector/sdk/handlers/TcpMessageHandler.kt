package ru.smartagro.connector.sdk.handlers

import io.vertx.core.net.NetSocket

interface TcpMessageHandler : MessageHandler {

    fun onConnect(socket: NetSocket)
}