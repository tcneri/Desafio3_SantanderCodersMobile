package com.example.desafio_webservices.services



import com.example.desafio_webservices.entities.Res
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface Service{


    @GET("comics")
    suspend fun getComicsRepo(
            @Query("offset")ps1:Int,
            @Query("limit")ps2:Int,
            @Query("ts")ps3:String,
            @Query("apikey")ps4:String,
            @Query("hash")ps5:String,
    ):Res

}

val urlApiMarvel = "https://gateway.marvel.com/v1/public/characters/1009491/"


val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(urlApiMarvel)
        .build()

val service:Service = retrofit.create(Service::class.java)