package com.astra.astramotormangement.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.astra.astramotormangement.MainActivity
import com.astra.astramotormangement.databinding.ActivityLoginBinding
import com.astra.astramotormangement.utils.UserPreference
import com.astra.astramotormangement.data.Result

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var preferences: UserPreference
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = UserPreference(this)

        if (preferences.getValues("status").equals("1")) {
            finishAffinity()

            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }

        loginViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                loginViewModel.login(username, password)
                loginViewModel.loginResult.observe(this) { result ->
                    when(result) {
                        is Result.Loading -> {
                            showLoading(true)
                        }

                        is Result.Success -> {
                            preferences.setValues("nama", result.data.loginResult.name)
                            preferences.setValues("username", result.data.loginResult.username)
                            preferences.setValues("status", "1")

                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finishAffinity()
                        }

                        is Result.Error -> {
                            Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this@LoginActivity, "Isi seluruh field", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.INVISIBLE
    }
}