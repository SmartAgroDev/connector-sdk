package ru.smartagro.connector.sdk.builders

import io.vertx.core.json.JsonObject
import org.springframework.stereotype.Component
import ru.smartagro.connector.sdk.builders.MessageBuilder
import java.util.Date

@Component
class MessageBuilderImpl : MessageBuilder {

    override fun putIdent(json: JsonObject, ident: String?) {
        json.put("ident", ident)
    }

    override fun putLongitude(json: JsonObject, longitude: Float?) {
        json.put("longitude", longitude)
    }

    override fun putLatitude(json: JsonObject, latitude: Float?) {
        json.put("latitude", latitude)
    }

    override fun putSpeed(json: JsonObject, speed: Float?) {
        json.put("speed", speed)
    }

    override fun putCourse(json: JsonObject, course: Double?) {
        json.put("course", course)
    }

    override fun putAltitude(json: JsonObject, altitude: Float?) {
        json.put("altitude", altitude)
    }

    override fun putSats(json: JsonObject, sats: Int?) {
        json.put("sats", sats)
    }

    override fun putHdop(json: JsonObject, hdop: Float?) {
        json.put("hdop", hdop)
    }

    override fun putTime(json: JsonObject, time: Date) {
        json.put("time", time.time)
    }
}