package com.ardentbot.web

import spark.Spark.get
import spark.Spark.port

fun main(args: Array<String>) {
    port(443)
    get("/invite") { _, response ->
        response.redirect("https://discordapp.com/api/oauth2/authorize?client_id=339101087569281045&permissions=8&scope=bot")
    }
    get("/support") { _, response ->
        response.redirect("https://discord.gg/VebBB5z")
    }
    get("/hub") { _, response ->
        response.redirect("https://discord.gg/VebBB5z")
    }
}