package com.eduztech.testdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eduztech.testdemo.adapter.RandomUserAdapter
import com.eduztech.testdemo.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var randomUserRv: RecyclerView
    private lateinit var recyclerAdapter: RandomUserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        randomUserRv = findViewById(R.id.randomUserRv)
        randomUserRv.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = RandomUserAdapter(this)
        randomUserRv.adapter = recyclerAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initViewModel() {
        val viewModel: MainActivityViewModel =
            ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null) {
                recyclerAdapter.setRandomUserData(it)
                recyclerAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"Error in getting data...",Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeAPICall("100")
    }
}