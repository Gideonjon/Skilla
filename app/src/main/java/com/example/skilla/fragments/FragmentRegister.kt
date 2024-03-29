package com.example.skilla.fragments

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.skilla.R
import com.example.skilla.databinding.FragmentRegisterBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


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





        val animationBounce = AnimationUtils.loadAnimation(context, R.anim.slide_right)




        binding.btnSignup.setOnClickListener {

            if (!Patterns.EMAIL_ADDRESS.matcher(binding.emailEt.text.toString()).matches()) {
                binding.email.error = "Input Correct Email"
                binding.email.requestFocus()
            }
            if (binding.pswEt.text.toString().isEmpty()) {
                binding.psw.error = "Input Password"
                binding.psw.requestFocus()

            } else {
                auth.createUserWithEmailAndPassword(
                    binding.emailEt.text.toString(),
                    binding.pswEt.text.toString()
                )
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            binding.toastCard.visibility = View.VISIBLE
                            binding.toastTxt.text = "Welcome Back, we missed you ...."
                            binding.toastTxt.visibility = View.VISIBLE
                            binding.progressBar.visibility = View.VISIBLE
                            binding.scrollView.setBackgroundColor(Color.WHITE)
                        }
                    }.addOnFailureListener {

                        binding.toastCard.visibility = View.VISIBLE

                        binding.toastTxt.text = "Check Your Internet Connection."

                        binding.toastTxt.startAnimation(animationBounce)
                        binding.toastTxt.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.INVISIBLE
                        binding.btnSignup.visibility = View.VISIBLE
                        binding.image1.visibility = View.INVISIBLE
                        binding.image2.visibility = View.INVISIBLE
                        binding.image3.visibility = View.INVISIBLE


                    }
            }
        }

        binding.signIn.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_fragmentRegister_to_fragmentLogin)
        }

        binding.apple.setOnClickListener {
            Toast.makeText(requireContext(), "Coming soon", Toast.LENGTH_SHORT).show()
        }

        binding.google.setOnClickListener {
            Toast.makeText(requireContext(), "Coming soon", Toast.LENGTH_SHORT).show()
        }




        return view


    }
/*

    private fun signInGoogle() {
        val signIntent = googleSignInClient.signInIntent
        launcher.launch(signIntent)
    }

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleResults(task)
            }
        }

    private fun handleResults(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful) {
            val account: GoogleSignInAccount? = task.result
            if (account !== null) {
                updateUi(account)
            }
            Toast.makeText(requireContext(), "Successful", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Not Successful", Toast.LENGTH_SHORT).show()
        }


    }

    private fun updateUi(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(requireContext(), "It is Successfully", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(requireContext(), "Not Successfully", Toast.LENGTH_SHORT).show()
        }

    }


    private fun buttonVerification() {

        binding.btnSignup.visibility = View.INVISIBLE

        if (!Patterns.EMAIL_ADDRESS.matcher(binding.emailEt.text.toString())
                .matches() && binding.pswEt.text.toString().isEmpty()
        ) {
            binding.btnSignup.visibility = View.INVISIBLE

        }
        if (Patterns.EMAIL_ADDRESS.matcher(binding.emailEt.text.toString())
                .matches() && binding.pswEt.text.toString().isEmpty()
        ) {
            binding.btnSignup.visibility = View.INVISIBLE

        }
        if (binding.pswEt.text.toString()
                .isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(binding.emailEt.text.toString())
                .matches()
        ) {
            binding.btnSignup.visibility = View.INVISIBLE

        } else {
            binding.btnSignup.visibility = View.VISIBLE

        }


    }
*/
}


