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
import com.google.firebase.auth.FirebaseAuth


class SecondSplashScreen : Fragment() {
    private var _binding: FragmentSecondSplashScreenBinding? = null
    private lateinit var auth: FirebaseAuth
    private val binding get() = _binding!!

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
                val intent = Intent(requireContext(), HomeActivity::class.java)
                activity?.startActivity(intent)
            } else {
                Navigation.findNavController(view).navigate(R.id.action_splashScreen_to_secondSplashScreen)
            }

        }, 7000)

        return view
    }

}