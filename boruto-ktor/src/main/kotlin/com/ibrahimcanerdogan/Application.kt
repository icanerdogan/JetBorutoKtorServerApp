package com.ibrahimcanerdogan

import com.ibrahimcanerdogan.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureKoin()
    configureRouting()
    configureSerialization()
    configureDefaultHeader()
    configureStatusPages()
}
