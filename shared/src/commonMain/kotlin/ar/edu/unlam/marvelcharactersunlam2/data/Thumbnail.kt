package ar.edu.unlam.marvelcharactersunlam2.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Thumbnail(
    @SerialName("path") val path: String,
    @SerialName("extension") val extension: String
) {
    fun toUrl() = "$path.$extension"
}