package com.example.myhappyplants.ui.screens.plantslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhappyplants.databinding.FragmentPlantsListBinding
import com.example.myhappyplants.ui.PlantsRVAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlantsListFragment : Fragment() {

    private val viewModel: PlantsListViewModel by viewModels()
    private var _binding: FragmentPlantsListBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlantsListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val plantsAdapter = PlantsRVAdapter(requireContext())
        viewModel.loadPlants(1)

        setupViews(plantsAdapter)
        setupObservers(plantsAdapter)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViews(plantsAdapter: PlantsRVAdapter) {
        with(binding.recyclerPlantsList) {
            layoutManager = LinearLayoutManager(context)
            adapter = plantsAdapter
        }

    }

    private fun setupObservers(plantsAdapter: PlantsRVAdapter) {
        viewModel.plantsData.observe(viewLifecycleOwner) {
            plantsAdapter.differ.submitList(it)
        }
        viewModel.loadingState.observe(viewLifecycleOwner) {
            binding.mainScreenPageProgressBar.isVisible = it
        }
    }


}