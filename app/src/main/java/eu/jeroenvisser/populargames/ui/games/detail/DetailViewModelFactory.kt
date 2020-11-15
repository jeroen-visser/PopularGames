package eu.jeroenvisser.populargames.ui.games.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import eu.jeroenvisser.populargames.data.entities.Game

class DetailViewModelFactory(
    private val game: Game,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(game, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}