package com.example.desafio_webservices.entities

import java.io.Serializable

data class Res(
        val data:Data)

data class Data(
        val offset : Int,
        val results : ArrayList<Results>)

data class Results(
        val id :Int,
        val title : String,
        val images : List<Images>,
        val description : String,
        val prices : List<Prices>,
        val dates : ArrayList<Dates>,
        val pageCount : Int

        ):Serializable

data class Images (

        val path : String,
        val extension : String
)

data class Prices (

        val type : String,
        val price : Double
)

data class Dates (

        val type : String,
        val date : String
)