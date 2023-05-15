package com.pucuk.latihan_newsapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pucuk.latihan_newsapi.databinding.ItemSourceBinding
import com.pucuk.latihan_newsapi.model.Source

class SourceAdapter(var listSource : List<Source>): RecyclerView.Adapter<SourceAdapter.ViewHolder>() {

    class ViewHolder(var binding : ItemSourceBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemSourceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.nameSource.text = listSource[position].name
    }

    override fun getItemCount(): Int {
        return  listSource.size
    }
}