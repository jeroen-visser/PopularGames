package eu.jeroenvisser.populargames.ui.games.overview

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.jeroenvisser.populargames.data.entities.Game
import eu.jeroenvisser.populargames.data.repository.GameRepository
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel @ViewModelInject constructor(
    private val gameRepository: GameRepository
) : ViewModel() {

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
        get() = _status

    private val _games = MutableLiveData<List<Game>>()
    val games: LiveData<List<Game>>
        get() = _games

    private val _navigateToSelectedGame = MutableLiveData<Game>()
    val navigateToSelectedGame: LiveData<Game>
        get() = _navigateToSelectedGame

    fun loadGames(forceRefresh: Boolean = false) {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _status.value = ApiStatus.DONE
                _games.value = gameRepository.games(forceRefresh)
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _games.value = ArrayList()
            }
        }
    }

    fun displayGameDetails(game: Game) {
        _navigateToSelectedGame.value = game
    }

    fun displayGameDetailsOnComplete() {
        _navigateToSelectedGame.value = null
    }
}

sealed class MainStateEvent{

    object GetGamesEvent: MainStateEvent()

    object None: MainStateEvent()
}