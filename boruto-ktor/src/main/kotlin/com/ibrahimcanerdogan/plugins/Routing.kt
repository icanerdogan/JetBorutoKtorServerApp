package com.ibrahimcanerdogan.plugins

import com.ibrahimcanerdogan.routes.getAllHeroes
import com.ibrahimcanerdogan.routes.root
import com.ibrahimcanerdogan.routes.searchHeroes
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        root()
        getAllHeroes()
        searchHeroes()

        staticResources(remotePath = "/images", basePackage = "images")
    }
}
