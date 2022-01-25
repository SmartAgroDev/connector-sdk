package ru.smartagro.connector.sdk.utils

import io.vertx.core.Vertx
import io.vertx.kotlin.core.executeBlockingAwait
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

lateinit var vertxInstance: Vertx

suspend fun <T> launchBlocking(f: () -> T): T {

    return Vertx.currentContext().owner().executeBlockingAwait<T> {
        try {
            it.complete(f())
        } catch (t: Throwable) {
            it.fail(t)
        }
    }!!
}

fun <T> await(f: suspend () -> T): T {

    return runBlocking(vertxInstance.dispatcher()) {
        f()
    }
}

fun async(f: suspend () -> Unit) {

    GlobalScope.launch(vertxInstance.dispatcher()) {
        f()
    }
}