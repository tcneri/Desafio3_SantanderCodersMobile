package com.example.desafio_webservices.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafio_webservices.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setSupportActionBar(toolbarR)
        toolbarR.setNavigationOnClickListener {
            onBackPressed()
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}