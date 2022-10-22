package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterApiRest(

    var name: String,
    var gender: String,
    var culture: String,
)
