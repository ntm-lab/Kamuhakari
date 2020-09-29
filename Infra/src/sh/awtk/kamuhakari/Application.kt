package sh.awtk.kamuhakari

import io.ktor.application.*
import io.ktor.auth.Authentication
import io.ktor.auth.authenticate
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.Locations
import io.ktor.locations.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.websocket.*
import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.websocket.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.content.TextContent
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.util.*
import io.ktor.utils.io.*
import io.ktor.websocket.WebSockets

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@KtorExperimentalLocationsAPI
@Suppress("unused") // Referenced in application.conf
fun Application.kamuhakari() {

    install(Locations)
    install(WebSockets)
    val client = HttpClient(OkHttp)
    routing {

        // ワンタイムURLの認証+トークン付与
        @Location("/join/{room}/{key}")
        data class JoinLocation(val room: String, val key: String)
        get<JoinLocation> { }

        // ルームの作成
        post("/room") {

        }

        authenticate {
            webSocket("/") {
                val frame = incoming.receive()
            }
        }

    }
}

