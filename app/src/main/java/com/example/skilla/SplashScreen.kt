package com.example.skilla

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.skilla.databinding.FragmentSplashScreenBinding

class SplashScreen : Fragment() {
    private var _binding: FragmentSplashScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)

        val view = binding.root

        Handler().postDelayed({
            Navigation.findNavController(view)
                .navigate(R.id.action_splashScreen_to_secondSplashScreen)
        }, 9000)

        return view
    }

}