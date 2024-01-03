package com.example.skilla.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.skilla.R
import com.example.skilla.adapters.Onboarding
import com.example.skilla.databinding.FragmentViewpagerBinding
import com.example.skilla.onboarding.FirstScreen
import com.example.skilla.onboarding.SecondScreen
import com.example.skilla.onboarding.ThirdScreen


class ViewpagerFragment : Fragment() {
     private var _binding : FragmentViewpagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentViewpagerBinding.inflate(inflater,container,false)
        val view = binding.root

        var fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )


        val adapter = Onboarding(
            fragmentList,
            requireActivity().supportFragmentManager, lifecycle
        )
        binding.viewpager.adapter = adapter


        return view
    }


}