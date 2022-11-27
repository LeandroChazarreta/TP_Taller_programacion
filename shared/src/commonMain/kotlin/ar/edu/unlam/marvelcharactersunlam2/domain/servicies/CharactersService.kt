package ar.edu.unlam.marvelcharactersunlam2.domain.servicies

import ar.edu.unlam.marvelcharactersunlam2.data.Character
import ar.edu.unlam.marvelcharactersunlam2.data.CharactersResponse
import ar.edu.unlam.marvelcharactersunlam2.domain.repository.CharactersRepository
import ar.edu.unlam.marvelcharactersunlam2.utils.CharactersComparator
import ar.edu.unlam.marvelcharactersunlam2.utils.HashGenerator
import ar.edu.unlam.marvelcharactersunlam2.utils.PrivateKey
import ar.edu.unlam.marvelcharactersunlam2.utils.PublicKey
import io.ktor.util.date.*

class CharactersService {

    private val characterComparator = CharactersComparator()
    private val charactersRepository = CharactersRepository()

    suspend fun getMarvelCharacters() : List<Character> {
        val timestamp = getTimeMillis()

        val charactersResponse = charactersRepository.getMarvelCharacters(
            timestamp,
            HashGenerator.md5(timestamp.toString() + PrivateKey + PublicKey)
        )

        val characters = charactersResponse.toModel()

        return sortCharacters(characters)
    }

    private fun CharactersResponse.toModel(): List<Character> {
        return this.characters.list.map {
            Character(
                id = it.id,
                name = it.name,
                description = it.description,
                thumbnailUrl = it.thumbnail.toUrl()
            )
        }
    }

    fun sortCharacters(characters: List<Character>): List<Character> {
        return characters.sortedWith(characterComparator)
    }
}