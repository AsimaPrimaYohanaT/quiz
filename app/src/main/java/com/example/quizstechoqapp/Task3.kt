package com.example.quizstechoqapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizstechoqapp.databinding.ActivityTask3Binding
import com.example.quizstechoqapp.response.ResponseItem

class Task3 : AppCompatActivity() {
    private lateinit var binding: ActivityTask3Binding
    private lateinit var viewModel: Task3ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvItem.apply {
            layoutManager = LinearLayoutManager(context)
            val itemDecoration =
                DividerItemDecoration(context, (layoutManager as LinearLayoutManager).orientation)
            binding.rvItem.addItemDecoration(itemDecoration)
            setHasFixedSize(true)
        }

        viewModel=ViewModelProvider(this).get(Task3ViewModel::class.java)
        Task3ViewModel().user.observe(this){hasil ->
            setData(hasil)
        }
    }


    private fun setData(listUser: List<ResponseItem>) {
        val adapter = Task3Adapter(listUser)

        binding.rvItem.adapter = adapter
    }
}