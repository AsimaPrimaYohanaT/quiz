package com.example.quizstechoqapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizstechoqapp.databinding.ActivityTask2aBinding

class Task2a : AppCompatActivity() {
    lateinit var binding: ActivityTask2aBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask2aBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val intent = Intent(this@Task2a,Task2b::class.java)
            startActivity(intent)
        }
    }
}