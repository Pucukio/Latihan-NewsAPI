package com.pucuk.latihan_newsapi.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pucuk.latihan_newsapi.R
import com.pucuk.latihan_newsapi.databinding.ActivitySourceBinding
import com.pucuk.latihan_newsapi.ui.adapter.SourceAdapter
import com.pucuk.latihan_newsapi.ui.viewmodel.SourceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourceActivity : AppCompatActivity() {
    lateinit var binding : ActivitySourceBinding
    lateinit var sourceAdapter : SourceAdapter
    lateinit var sourceVm : SourceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sourceVm = ViewModelProvider(this).get(SourceViewModel::class.java)
        sourceAdapter = SourceAdapter(ArrayList())
        sourceVm.getDataSource().observe(this, Observer {
            sourceAdapter = SourceAdapter(it!!)
            val layoutMan = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvSource.layoutManager = layoutMan
            binding.rvSource.adapter = sourceAdapter
        })

        val datacat = intent.extras!!.getString("name")
        sourceVm.callApiSource(datacat.toString())
    }

}