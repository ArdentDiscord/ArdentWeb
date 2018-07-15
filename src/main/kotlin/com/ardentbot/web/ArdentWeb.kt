package com.ardentbot.web

import spark.ModelAndView
import spark.Spark.*
import spark.template.handlebars.HandlebarsTemplateEngine

val secure = false

fun main(args: Array<String>) {
    val handlebars = HandlebarsTemplateEngine()

    staticFileLocation("public")
    if (secure) {
        secure(args[1], "ardent", null, null)
        port(443)
    } else port(80)
    exception(Exception::class.java) { exception, request, response -> exception.printStackTrace() }

    get("/invite") { _, response ->
        response.redirect("https://discordapp.com/api/oauth2/authorize?client_id=339101087569281045&permissions=8&scope=bot")
    }
    get("/support") { _, response ->
        response.redirect("https://discord.gg/VebBB5z")
    }
    get("/hub") { _, response ->
        response.redirect("https://discord.gg/VebBB5z")
    }
    get("/patreon") { _, response ->
        response.redirect("https://www.patreon.com/ardent")
    }

    get("/", { _, response ->
        val map = hashMapOf<String, Any>()
        ModelAndView(map, "index.hbs")
    }, handlebars)
}