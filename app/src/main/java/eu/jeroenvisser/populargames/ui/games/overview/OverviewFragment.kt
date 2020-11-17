package eu.jeroenvisser.populargames.ui.games.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import eu.jeroenvisser.populargames.R
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
        fetchGames()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchGames()

        // Allows data binding to Observe LiveData with the lifecycle
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.swipeContainer.setOnRefreshListener(this)

        val adapter = GameOverviewAdapter(GameOverviewAdapter.OnClickListener {
            this.findNavController().navigate(
                OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it)
            )
        })

        binding.gameOverviewRecyclerView.adapter = adapter
        viewModel.games.observe(viewLifecycleOwner, {
            adapter.submitList(it)
            binding.swipeContainer.isRefreshing = false
        })

        viewModel.status.observe(viewLifecycleOwner, {
            when(it) {
                ApiStatus.ERROR -> renderSnackbar()
                else -> {}
            }
        })

        setHasOptionsMenu(true)
    }

    private fun renderSnackbar() {
        binding.swipeContainer.isRefreshing = false
        Snackbar
            .make(
                binding.root,
                getString(R.string.error_loading_games),
                Snackbar.LENGTH_LONG
            )
            .setAction(getString(R.string.retry)) { viewModel.loadGames() }
            .show()
    }

    fun fetchGames() {
        viewModel.loadGames()
        binding.swipeContainer.isRefreshing = true
    }
}