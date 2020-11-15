package eu.jeroenvisser.populargames.ui.games.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import eu.jeroenvisser.populargames.data.entities.Game

class DetailViewModel(game: Game, app: Application) : AndroidViewModel(app) {

    private val _selectedGame = MutableLiveData<Game>()

    val selectedGame: LiveData<Game>
        get() = _selectedGame

    init {
        _selectedGame.value = game
    }

}