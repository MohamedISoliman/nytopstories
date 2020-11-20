package io.github.mohamedisoliman.nytopstories.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import io.github.mohamedisoliman.nytopstories.databinding.FragmentMainBinding
import io.github.mohamedisoliman.nytopstories.ui.main.home.HomeViewModel

class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: HomeViewModel
    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(HomeViewModel::class.java).apply {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        pageViewModel.errors().observe(viewLifecycleOwner) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        }

        pageViewModel.loading().observe(viewLifecycleOwner) {
            if (it) {
                Snackbar.make(binding.root, "Loading", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(binding.root, "DONE", Snackbar.LENGTH_LONG).show()
            }

        }

        pageViewModel.topStories().observe(viewLifecycleOwner) {
            Snackbar.make(binding.root, "HEEEY WE GOT RESULT", Snackbar.LENGTH_LONG).show()
        }
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
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