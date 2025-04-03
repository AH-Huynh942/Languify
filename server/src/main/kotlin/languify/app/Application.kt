package languify

import io.ktor.server.application.*
import com.detectlanguage.DetectLanguage

import java.util.Properties
import java.io.File

fun loadApiKey(): String? {
    val properties = Properties()
    val file = File("local.properties")
    if (file.exists()) {
        properties.load(file.inputStream())
        return properties.getProperty("API_KEY")
    }
    return null
}

fun main(args: Array<String>) {
    println("\nIS THIS RUNNING\n")
    val apiKey = loadApiKey()
    DetectLanguage.apiKey = apiKey
    val english = "Hello how are you"
    val french = "Bonjour tout le monde"
    val punjabi = "ਪਰਮਿੰਦਰਜੀਤ"
    val english_result = DetectLanguage.simpleDetect(english)
    val french_result = DetectLanguage.simpleDetect(french)
    val punjabi_result = DetectLanguage.simpleDetect(punjabi)
    val output = String.format("\nEnglish Result: %s, French Result: %s, Punjabi Result: %s\n", english_result, french_result, punjabi_result)
    println(output)
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureHTTP()
    configureSerialization()
    configureDatabases()
    configureMonitoring()
    configureRouting()
}
