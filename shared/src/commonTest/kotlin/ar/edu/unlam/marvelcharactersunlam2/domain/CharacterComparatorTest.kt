package ar.edu.unlam.marvelcharactersunlam2.domain

import ar.edu.unlam.marvelcharactersunlam2.data.Character
import ar.edu.unlam.marvelcharactersunlam2.utils.CharactersComparator
import kotlin.test.Test
import kotlin.test.*

class CharacterComparatorTest {

    @Test
    fun compare_with_empty_characters_description_should_return_integer() {
        // Arrange
        val character1 = Character(1L, "Dr. Strange", "", "url")
        val character2 = Character(2L, "Black Panter", "", "url")

        // Act
        val result = CharactersComparator().compare(character1, character2)

        // Assert
        assertEquals(result, 1)
    }

    @Test
    fun compare_with_not_empty_characters_description_should_return_integer() {
        // Arrange
        val character1 = Character(1L, "Dr. Strange", "The Sorcerer Supreme", "url")
        val character2 = Character(2L, "Black Panther", "King of wakanda", "url")

        // Act
        val result = CharactersComparator().compare(character1, character2)

        // Assert
        assertEquals(result, -1)
    }

    @Test
    fun compare_with_not_empty_character1_description_and_empty_character2_description_should_return_integer() {
        // Arrange
        val character1 = Character(1L, "Dr. Strange", "The Sorcerer Supreme", "url")
        val character2 = Character(2L, "Black Panther", "", "url")

        // Act
        val result = CharactersComparator().compare(character1, character2)

        // Assert
        assertEquals(result, -1)
    }

}