package com.example.myhappyplants.ui.screens.startpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myhappyplants.R
import com.example.myhappyplants.databinding.FragmentStartPageBinding

class StartPageFragment : Fragment() {
    private var _binding: FragmentStartPageBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartPageBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.LogInButtonStart.setOnClickListener {
            findNavController().navigate(R.id.action_startPageFragment_to_loginPageFragment)
        }
        binding.RegisterButtonStart.setOnClickListener {
            findNavController().navigate(R.id.action_startPageFragment_to_loginPageFragment)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}