package languify

import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.openapi.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.*
import org.slf4j.event.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello Sarah, Gurmanjot, Cheukman, Ke Ma, and the Great One! Ready to make an app!?")
        }
        get("/language/id={}") {
            call.respondText("Hello Sarah, Gurmanjot, Cheukman, Ke Ma, and the Great One! Ready to make an app!?")
        }

    }

}
