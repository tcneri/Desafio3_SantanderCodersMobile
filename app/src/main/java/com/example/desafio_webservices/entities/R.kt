package com.example.desafio_webservices.entities

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
        val prices : List<Prices>

        )

data class Images (

        val path : String,
        val extension : String
)

data class Prices (

        val type : String,
        val price : Double
)