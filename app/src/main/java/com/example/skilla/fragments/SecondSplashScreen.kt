package com.example.skilla.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.skilla.R
import com.example.skilla.databinding.FragmentSecondSplashScreenBinding


class SecondSplashScreen : Fragment() {
    private var _binding: FragmentSecondSplashScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentSecondSplashScreenBinding.inflate(inflater, container, false)
        val view = binding.root

        Handler().postDelayed({

            Navigation.findNavController(view).navigate(R.id.action_secondSplashScreen_to_viewpagerFragment)

        },7000)


        return view
    }

}