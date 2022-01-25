package ru.smartagro.connector.sdk.handlers

import io.vertx.ext.web.RoutingContext

interface HttpMessageHandler : MessageHandler {

    suspend fun onRequest(routingContext: RoutingContext)
}