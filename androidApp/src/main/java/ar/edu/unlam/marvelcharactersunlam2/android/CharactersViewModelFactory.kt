package ar.edu.unlam.marvelcharactersunlam2.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ar.edu.unlam.marvelcharactersunlam2.domain.servicies.CharactersService

class CharactersViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val charactersService = CharactersService()
        return CharactersViewModel(charactersService) as T
    }
}