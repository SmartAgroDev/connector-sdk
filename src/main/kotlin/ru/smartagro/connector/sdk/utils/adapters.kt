package ru.smartagro.connector.sdk.utils

import io.vertx.core.Vertx
import io.vertx.kotlin.core.executeBlockingAwait
import io.vertx.kotlin.coroutines.dispatcher
import io.vertx.kotlin.coroutines.receiveChannelHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


suspend fun <T> launchBlocking(f: () -> T): T {

    return Vertx.currentContext().executeBlockingAwait<T> {
        try {
            it.complete(f())
        } catch (t: Throwable) {
            it.fail(t)
        }
    }!!
}

fun <T> await(f: suspend () -> T): T {

    return runBlocking(Vertx.currentContext().dispatcher()) {
        f()
    }
}

fun <T> asyncHandler(handler: suspend (T) -> Unit) = Vertx.currentContext().owner().receiveChannelHandler<T>().apply {
    launch(coroutineContext) {
        for (it in this@apply) {
            handler(it)
        }
    }
}