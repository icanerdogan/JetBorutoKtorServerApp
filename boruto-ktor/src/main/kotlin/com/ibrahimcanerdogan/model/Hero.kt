package com.ibrahimcanerdogan.model

import kotlinx.serialization.Serializable

@Serializable
data class Hero(
    val heroId: Int,
    val heroName: String,
    val heroImage: String,
    val heroAbout: String,
    val heroRating: Double,
    val heroPower: Int,
    val heroMonth: String,
    val heroDay: String,
    val heroFamily: List<String>,
    val heroAbilities: List<String>,
    val heroNatureTypes: List<String>
)
