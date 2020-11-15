package eu.jeroenvisser.populargames.ui.games.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import eu.jeroenvisser.populargames.databinding.GameDetailFragmentBinding

@AndroidEntryPoint
class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application

        val binding = GameDetailFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val game = DetailFragmentArgs.fromBundle(requireArguments()).selectedGame
        val viewModelFactory = DetailViewModelFactory(game, application)

        binding.viewModel = ViewModelProvider(this, viewModelFactory).get(
            DetailViewModel::class.java
        )

        return binding.root
    }
}