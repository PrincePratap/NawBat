package com.nawbat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nawbat.databinding.FragmentGetStartedBinding


class GetStartedFragment : Fragment() {

    private lateinit var binding : FragmentGetStartedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentGetStartedBinding.inflate(inflater ,container,false)

        binding.textSignUpFreeGet.setOnClickListener {
            Log.d("yo-yo", "onCreateView: Hello")
            findNavController().navigate(R.id.action_getStartedFragment_to_signUpFragment)
        }

        binding.textLoginGet.setOnClickListener {
            Log.d("yo-yo", "onCreateView: Hello")
            findNavController().navigate(R.id.action_getStartedFragment_to_loginFragment)
        }

    return binding.root
    }

}