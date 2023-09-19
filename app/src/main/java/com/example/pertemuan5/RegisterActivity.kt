package com.example.pertemuan5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pertemuan5.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding;

    companion object{
        const val username = "username"
        const val email = "email"
        const val phone = "phone"
        const val password = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            toHomepage.setOnClickListener{
                if(edtUsername.text.toString()!="" && edtEmail.text.toString()!="" && edtPassword.text.toString()!="" && edtPhone.text.toString()!="") {
                    if(binding.acc.isChecked) {
                        val intentHome = Intent(this@RegisterActivity, LoginActivity::class.java)
                        intentHome.putExtra(username, edtUsername.text.toString())
                        intentHome.putExtra(email, edtEmail.text.toString())
                        intentHome.putExtra(phone, edtPhone.text.toString())
                        intentHome.putExtra(password, edtPassword.text.toString())
                        startActivity(intentHome)
                    }else{
                        Toast.makeText(this@RegisterActivity, "isi checkboxnya dulu", Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    Toast.makeText(this@RegisterActivity, "Kolom tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }
            }

            toLogin.setOnClickListener{
                val intentLogin = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intentLogin)
            }
        }
    }
}