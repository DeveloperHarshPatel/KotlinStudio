package com.hp.kotlinstudio.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hp.kotlinstudio.R
import com.hp.kotlinstudio.model.Title
import kotlinx.android.synthetic.main.list_item.view.*

class TitleAdapter(private val mItems : ArrayList<Title>, private val mContext: Context) : RecyclerView.Adapter<TitleAdapter.TitleViewHolder>() {

    class TitleViewHolder(view: View):RecyclerView.ViewHolder(view){
        val tvTitle = view.tv_title!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleViewHolder {
        return TitleViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false))
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
        holder.tvTitle.text = mItems[position].name
    }

}