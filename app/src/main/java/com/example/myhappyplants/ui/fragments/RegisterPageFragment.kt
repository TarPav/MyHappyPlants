package com.example.myhappyplants.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myhappyplants.R
import com.example.myhappyplants.databinding.FragmentRegisterPageBinding
import com.example.myhappyplants.databinding.FragmentStartPageBinding

class RegisterPageFragment : Fragment() {

    private var _binding: FragmentRegisterPageBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterPageBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO change R.id.fragment
        binding.SignInButton.setOnClickListener {
            findNavController().navigate(R.id.action_startPageFragment_to_loginPageFragment)
        }
        binding.RegisterSignInButton.setOnClickListener {
            findNavController().navigate(R.id.action_startPageFragment_to_loginPageFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}