package ar.edu.unlam.marvelcharactersunlam2.data

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val id: Long,
    val name: String,
    val description: String,
    val thumbnailUrl: String
)

