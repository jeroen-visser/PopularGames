package eu.jeroenvisser.populargames.ui.games.overview

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.jeroenvisser.populargames.data.repository.GameRepository
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel @ViewModelInject constructor(
    private val gameRepository: GameRepository
) : ViewModel() {

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
        get() = _status

    val games = gameRepository.getGames()

    fun loadGames() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _status.value = ApiStatus.DONE
                gameRepository.loadGames()
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
            }
        }
    }

}