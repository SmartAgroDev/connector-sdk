package ru.smartagro.connector.sdk.builders

import io.vertx.core.json.JsonObject
import java.util.Date

interface MessageBuilder {

    fun putLongitude(json: JsonObject, longitude: Float?)

    fun putLatitude(json: JsonObject, latitude: Float?)

    fun putSpeed(json: JsonObject, speed: Float?)

    fun putCourse(json: JsonObject, course: Double?)

    fun putAltitude(json: JsonObject, altitude: Float?)

    fun putSats(json: JsonObject, sats: Int?)

    fun putHdop(json: JsonObject, hdop: Float?)

    fun putIdent(json: JsonObject, ident: String?)

    fun putTime(json: JsonObject, time: Date)
}