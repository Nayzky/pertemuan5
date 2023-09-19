package com.example.pertemuan5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pertemuan5.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val usernames = intent.getStringExtra(RegisterActivity.username)
        val emails = intent.getStringExtra(RegisterActivity.email)
        val phones = intent.getStringExtra(RegisterActivity.phone)
        val passwords = intent.getStringExtra(RegisterActivity.password)

        with(binding){

            txtUsername.text = "Selamat datang $usernames !!"
            txtEmail.text = "Your email : $emails"
            txtPhone.text = "Your phone number : $phones"
        }
    }
}