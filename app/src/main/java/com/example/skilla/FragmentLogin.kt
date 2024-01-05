package com.example.skilla

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.skilla.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth


class FragmentLogin : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        auth = FirebaseAuth.getInstance()


        binding.btnLogin.setOnClickListener {
            if (!Patterns.EMAIL_ADDRESS.matcher(binding.emailEt.text.toString()).matches())
                binding.email.error = "Input Correct Email"
            binding.email.requestFocus()
        }
        if (binding.pswEt.text.toString().isEmpty()) {
            binding.psw.error = "Input Password"
            binding.psw.requestFocus()
        } else {
            auth.signInWithEmailAndPassword(
                binding.emailEt.text.toString(),
                binding.pswEt.text.toString()
            )
                .addOnCanceledListener {
                    if(){

                    }
                }
        }

        return view
    }


}