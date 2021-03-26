package com.example.recyclermultiple1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclermultiple1.R

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listViewType = mutableListOf(
            MultiViewRecyclerAdapter.TEXT_VIEW,
            MultiViewRecyclerAdapter.IMAGE_VIEW,
            MultiViewRecyclerAdapter.IMAGE_WITH_TEXT_VIEW,
            MultiViewRecyclerAdapter.TEXT_VIEW,
            MultiViewRecyclerAdapter.IMAGE_VIEW,
            MultiViewRecyclerAdapter.IMAGE_WITH_TEXT_VIEW
        )
        val adapterRecyclerView = MultiViewRecyclerAdapter(this, listViewType = listViewType)
        recyclerView.adapter = adapterRecyclerView
    }
}