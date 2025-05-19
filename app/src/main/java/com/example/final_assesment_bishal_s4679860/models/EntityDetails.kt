package com.example.final_assesment_bishal_s4679860.models

//This is the model we'll showing in detail screen
data class EntityDetails(
    val species: String,
    val scientificName: String,
    val habitat: String,
    val diet: String,
    val conservationStatus: String,
    val averageLifespan: Int,
    val description: String,
    )
