package sh.awtk.kamuhakari

import io.ktor.application.Application
import io.ktor.routing.get
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
fun Application.kamuhakari() {
    routing {
        // TODO Create root
    }
}

