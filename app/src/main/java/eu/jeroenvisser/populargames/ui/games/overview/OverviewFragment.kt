package eu.jeroenvisser.populargames.ui.games.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import eu.jeroenvisser.populargames.data.entities.Game
import eu.jeroenvisser.populargames.databinding.GameOverviewFragmentBinding
import eu.jeroenvisser.populargames.utils.DataState

@AndroidEntryPoint
class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = GameOverviewFragmentBinding.inflate(inflater, container, false)

        // Allows data binding to Observe LiveData with the lifecycle
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.gameOverviewRecyclerView.adapter = GameOverviewAdapter(GameOverviewAdapter.OnClickListener {
            viewModel.displayGameDetails(it)
        })

        viewModel.navigateToSelectedGame.observe(viewLifecycleOwner, {
            if (null != it) {
                this.findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it))
                viewModel.displayGameDetailsOnComplete()
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }
}