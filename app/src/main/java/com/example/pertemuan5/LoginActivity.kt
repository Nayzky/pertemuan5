package com.example.pertemuan5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pertemuan5.databinding.ActivityHomeBinding
import com.example.pertemuan5.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding;

    companion object{
        const val username = "username"
        const val phone = "phone"
        const val email = "email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usernames = intent.getStringExtra(RegisterActivity.username)
        val emails = intent.getStringExtra(RegisterActivity.email)
        val passwords = intent.getStringExtra(RegisterActivity.password)
        val phones = intent.getStringExtra(RegisterActivity.phone)


        with(binding){
            toHomepage.setOnClickListener {
                if(edtUsername.text.toString()!="" && edtPassword.text.toString()!="") {
                    if (( emails == edtUsername.text.toString() || usernames == edtUsername.text.toString() ) && passwords == edtPassword.text.toString() )  {
                        val intentLogin = Intent(this@LoginActivity, HomeActivity::class.java)
                        intentLogin.putExtra(username, usernames)
                        intentLogin.putExtra(phone, phones)
                        intentLogin.putExtra(email, emails)
                        startActivity(intentLogin)
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Username atau Password Salah",
                            Toast.LENGTH_SHORT
                        ).show() }
                }else{
                    Toast.makeText(this@LoginActivity, "kolom tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }
            }

            toRegister.setOnClickListener{
                val intentRegis = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intentRegis)
            }
        }
    }
}