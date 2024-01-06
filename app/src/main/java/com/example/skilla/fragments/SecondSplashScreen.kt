package com.example.skilla.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.skilla.R
import com.example.skilla.activity.HomeActivity
import com.example.skilla.databinding.FragmentSecondSplashScreenBinding
import com.example.skilla.databinding.FragmentSplashScreenBinding
import com.google.firebase.auth.FirebaseAuth


class SecondSplashScreen : Fragment() {
    private var _binding: FragmentSecondSplashScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentSecondSplashScreenBinding.inflate(inflater, container, false)
        val view = binding.root




        auth = FirebaseAuth.getInstance()

        Handler(Looper.myLooper()!!).postDelayed(Runnable {
            if (auth.currentUser != null) {
                val  intent = Intent(requireContext(), HomeActivity::class.java)
                activity?.startActivity(intent)
            } else {
                Navigation.findNavController(view)
                    .navigate(R.id.action_secondSplashScreen_to_viewpagerFragment)
            }

        }, 7000)
        return view
    }
}