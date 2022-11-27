package ar.edu.unlam.marvelcharactersunlam2.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponse(
    @SerialName("data") val characters: CharacterData
)