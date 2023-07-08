package com.example.ard_survey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ard_survey.databinding.ActivityLoginBinding
import com.example.ard_survey.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener{
            val email = binding.emailEt.text.toString()
            val password = binding.passET.text.toString()
            val confirmPassword = binding.confirmPassEt.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){
                if(password == confirmPassword) {
                        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                            if (it.isSuccessful){
                                    val intent = Intent(this, LoginActivity::class.java)
                                    startActivity(intent)
                            }else {
                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                            }
                        }
                }else {
                    Toast.makeText(this, "Passwords are not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "All field need to be filled out", Toast.LENGTH_SHORT).show()
            }
        }
    }
}