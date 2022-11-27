package ar.edu.unlam.marvelcharactersunlam2.data
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterData(
    @SerialName("results")
    val list: List<CharacterResult>
)
