package ar.edu.unlam.marvelcharactersunlam2.android

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.marvelcharactersunlam2.data.Character
import ar.edu.unlam.marvelcharactersunlam2.domain.servicies.CharactersService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val charactersService: CharactersService
) : ViewModel() {

    private val _screenState: MutableStateFlow<ScreenState> = MutableStateFlow(ScreenState.Loading)
    val screenState: Flow<ScreenState> = _screenState

    private val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d("CharactersViewModel", "Error retrieving characters: ${throwable.message}")
    }

    init {
        viewModelScope.launch(coroutineExceptionHandler) {
            val list = charactersService.getMarvelCharacters()
            _screenState.value = ScreenState.ShowCharacters(list)
        }
    }

}

sealed class ScreenState {

    object Loading : ScreenState()

    class ShowCharacters(val list: List<Character>) : ScreenState()
}