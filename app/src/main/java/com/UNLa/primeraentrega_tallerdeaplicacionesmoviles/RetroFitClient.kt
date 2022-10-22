package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

public object RetroFitClient {
    private val baseURL = "https://anapioficeandfire.com/api/";

    public val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())//es el adapter-lo fabrica
        .build();

    //le pasa la url y el adapter
    val retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build();
}