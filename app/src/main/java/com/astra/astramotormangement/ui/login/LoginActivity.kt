package com.astra.astramotormangement.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.astra.astramotormangement.MainActivity
import com.astra.astramotormangement.databinding.ActivityLoginBinding
import com.astra.astramotormangement.model.User
import com.astra.astramotormangement.utils.UserPreference
import com.google.firebase.database.*

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    lateinit var mDatabase: DatabaseReference
    lateinit var preferences: UserPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preferences = UserPreference(this)

        if (preferences.getValues("status").equals("1")) {
            finishAffinity()

            var intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()

            if (username.isEmpty()) {
                binding.edtUsername.error = "Silahkan isi username"
                binding.edtUsername.requestFocus()
            } else if (password.isEmpty()) {
                binding.edtPassword.error = "Silahkan isi password"
                binding.edtUsername.requestFocus()
            } else {
                login(username, password)
            }
        }
    }

    private fun login(username: String, password: String) {
        mDatabase.child(username).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var user = dataSnapshot.getValue(User::class.java)

                if (user == null) {
                    Toast.makeText(
                        this@LoginActivity,
                        "User tidak ditemukan",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {
                    if (user.password.equals(password)) {
                        preferences.setValues("nama", user.name.toString())
                        preferences.setValues("username", user.username.toString())
                        preferences.setValues("status", "1")
                        var intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Password anda salah!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@LoginActivity,
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }
}