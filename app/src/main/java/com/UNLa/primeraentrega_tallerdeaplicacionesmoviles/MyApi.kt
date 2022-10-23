package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles

import retrofit2.Call
import retrofit2.http.GET

interface MyApi {

    // devuelve una lista de post. call y callback esperan las respuestas
    @GET("characters?page=58")
    fun getCharacters(): Call<List<CharacterApiRest>>
}