package com.example.skilla.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.skilla.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class FragmentRegister : Fragment() {
    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root
        auth = FirebaseAuth.getInstance()


        binding.btnSignup.visibility = View.INVISIBLE
        binding.toastCard.visibility = View.INVISIBLE

        binding.btnSignup.setOnClickListener {

            if (!Patterns.EMAIL_ADDRESS.matcher(binding.emailEt.text.toString()).matches())
                binding.email.error = "Input Correct Email"
            binding.email.requestFocus()
            binding.btnSignup.visibility = View.INVISIBLE
            binding.toastCard.visibility = View.INVISIBLE

        }
        if (binding.pswEt.text.toString().isEmpty()) {
            binding.psw.error = "Input Password"
            binding.psw.requestFocus()
            binding.btnSignup.visibility = View.INVISIBLE
            binding.toastCard.visibility = View.INVISIBLE

        } else {
            binding.btnSignup.visibility = View.VISIBLE
            auth.createUserWithEmailAndPassword(
                binding.emailEt.text.toString(),
                binding.pswEt.text.toString()
            )
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        binding.toastCard.visibility = View.VISIBLE
                        binding.toastTxt.text = "Welcome Back, we missed you ...."
                        binding.toastTxt.visibility = View.VISIBLE
                        binding.scrollView.setBackgroundColor(Color.GRAY)
                    }
                }.addOnFailureListener {

                    binding.toastCard.visibility = View.VISIBLE
                    binding.toastTxt.text = "Check Your Internet Connection."
                    binding.toastTxt.visibility = View.VISIBLE
                    binding.btnSignup.visibility = View.INVISIBLE

                }
        }





        return view
    }
}

