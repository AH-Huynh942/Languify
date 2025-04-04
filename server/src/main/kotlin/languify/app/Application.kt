package languify

import io.ktor.server.application.*

fun main(args: Array<String>) {
    val la:Expert = LatinExpert()
    val to = TextObtainer()
    val txt = to.stringToTextObject("Bonjour")
    val lang = la.guessLanguage(txt)
    println(lang.toString())

    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureHTTP()
    configureSerialization()
    configureDatabases()
    configureMonitoring()
    configureRouting()
}
