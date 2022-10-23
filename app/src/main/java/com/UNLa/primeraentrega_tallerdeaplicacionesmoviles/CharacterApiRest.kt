package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterApiRest(

    var id: String? = null,
    var name: String? = null,
    var gender: String? = null,
    var culture: String? = null,
    var born: String? = null,
    var died: String? = null,
    var father: String? = null,
    var mother: String? = null,
    var spouse: String? = null
)
