package eu.jeroenvisser.populargames.ui.games.overview

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import eu.jeroenvisser.populargames.data.entities.Game
import eu.jeroenvisser.populargames.data.repository.GameRepository

class OverviewViewModel @ViewModelInject constructor(
    repository: GameRepository
) : ViewModel() {

    val games: LiveData<List<Game>> = repository.games()

}