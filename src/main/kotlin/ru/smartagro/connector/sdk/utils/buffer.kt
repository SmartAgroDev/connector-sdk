package org.smartagro24.app.utils

import io.vertx.core.buffer.Buffer

fun Buffer.toHexString() = bytes.map { it.toString(16) }.joinToString(separator = " ")

fun Buffer.revert(): Buffer {
    return getBytes(0, length())
        .apply {
            reverse()
        }
        .let {
            Buffer.buffer(it)
        }
}
