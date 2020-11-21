package io.github.mohamedisoliman.nytopstories.ui.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import io.github.mohamedisoliman.nytopstories.R
import io.github.mohamedisoliman.nytopstories.databinding.FragmentMainBinding
import io.github.mohamedisoliman.nytopstories.ui.home.StoriesAdapter
import io.github.mohamedisoliman.nytopstories.ui.toVisibilityGone

class BookmarksFragment : Fragment() {

    private lateinit var pageViewModel: BookmarksViewModel
    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    private val storiesAdapter = StoriesAdapter { pageViewModel.onBookmarkClicked(it) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(BookmarksViewModel::class.java)

        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        val verticalGridSpacing = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            .apply {
                context?.getDrawable(R.drawable.spacing_divider)?.let { setDrawable(it) }
            }
        val horizontalGridSpacing = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
            .apply {
                context?.getDrawable(R.drawable.spacing_divider)?.let { setDrawable(it) }
            }

        with(binding.recyclerViewTopStories) {
            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(verticalGridSpacing)
            addItemDecoration(horizontalGridSpacing)
            adapter = storiesAdapter
        }
    }

    private fun setupObservers() {
        pageViewModel.errors().observe(viewLifecycleOwner) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        }

        pageViewModel.loading().observe(viewLifecycleOwner) {
            if (it) binding.progressCircular.show() else binding.progressCircular.hide()
        }

        pageViewModel.topStories().observe(viewLifecycleOwner) {
            binding.emptyView.visibility = it.isEmpty().toVisibilityGone()
            storiesAdapter.submitList(it)
        }
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): BookmarksFragment {
            return BookmarksFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}