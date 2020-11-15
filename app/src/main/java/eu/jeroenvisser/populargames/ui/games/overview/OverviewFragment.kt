package eu.jeroenvisser.populargames.ui.games.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

import eu.jeroenvisser.populargames.R
import eu.jeroenvisser.populargames.databinding.GameOverviewFragmentBinding

@AndroidEntryPoint
class OverviewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GameOverviewFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.game_overview_fragment, container, false
        )
        return binding.root
    }
}