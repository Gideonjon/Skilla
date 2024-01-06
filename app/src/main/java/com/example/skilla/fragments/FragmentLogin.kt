package com.example.skilla.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.skilla.R
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



        val animationBounce = AnimationUtils.loadAnimation(context, R.anim.slide_right)


        binding.btnLogin.setOnClickListener {
            if (!Patterns.EMAIL_ADDRESS.matcher(binding.emailEt.text.toString()).matches()) {
                binding.email.error = "Input Correct Email"
                binding.email.requestFocus()


            }
            if (binding.pswEt.text.toString().isEmpty()) {
                binding.psw.error = "Input Password"
                binding.psw.requestFocus()



            } else {
                binding.btnLogin.visibility = View.VISIBLE
                auth.signInWithEmailAndPassword(
                    binding.emailEt.text.toString(),
                    binding.pswEt.text.toString()
                )
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            binding.toastCard.visibility = View.VISIBLE
                            binding.toastTxt.text = "Welcome Back, we missed you ...."
                            binding.toastTxt.visibility = View.VISIBLE
                            binding.progressBar.visibility = View.VISIBLE
                            binding.scrollView.setBackgroundColor(Color.GRAY)


                        }

                    }.addOnFailureListener {

                        binding.toastCard.visibility = View.VISIBLE

                        binding.toastTxt.text = "Check Your Internet Connection."

                        binding.toastTxt.startAnimation(animationBounce)
                        binding.toastTxt.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.INVISIBLE
                        binding.btnLogin.visibility = View.VISIBLE
                        binding.image1.visibility = View.INVISIBLE
                        binding.image2.visibility = View.INVISIBLE
                        binding.image3.visibility = View.INVISIBLE
                    }
            }
        }

        binding.signUp.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentLogin_to_fragmentRegister)
        }

        return view
    }


}