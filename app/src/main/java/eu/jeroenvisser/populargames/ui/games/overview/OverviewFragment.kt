package eu.jeroenvisser.populargames.ui.games.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dagger.hilt.android.AndroidEntryPoint
import eu.jeroenvisser.populargames.databinding.GameOverviewFragmentBinding

@AndroidEntryPoint
class OverviewFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

    private lateinit var binding: GameOverviewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GameOverviewFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onRefresh() {
        fetchGames(forceRefresh = true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchGames()

        // Allows data binding to Observe LiveData with the lifecycle
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.swipeContainer.setOnRefreshListener(this)

        val adapter = GameOverviewAdapter(GameOverviewAdapter.OnClickListener {
            this.findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it))
            viewModel.displayGameDetailsOnComplete()
        })

        binding.gameOverviewRecyclerView.adapter = adapter
        viewModel.games.observe(viewLifecycleOwner, {
            adapter.submitList(it)
            binding.swipeContainer.isRefreshing = false
        })

        setHasOptionsMenu(true)
    }

    fun fetchGames(forceRefresh: Boolean = false) {
        viewModel.loadGames(forceRefresh)
        binding.swipeContainer.isRefreshing = true
    }
}