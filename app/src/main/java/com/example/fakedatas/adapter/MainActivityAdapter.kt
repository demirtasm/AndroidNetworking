package com.example.fakedatas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fakedatas.R
import com.example.fakedatas.datas.Data
import kotlinx.android.synthetic.main.item_view.view.*

class MainActivityAdapter(allDatas: MutableList<Data>) :
    RecyclerView.Adapter<MainActivityAdapter.MyViewHolder>() {

    var allDatasList = allDatas
    private lateinit var context: Context

    override fun getItemCount(): Int = allDatasList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        var inflater = LayoutInflater.from(context)
        var layoutView = inflater.inflate(R.layout.item_view, parent, false)
        return MyViewHolder(layoutView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemName?.text = allDatasList[position].firstName
        holder.itemMail?.text = allDatasList[position].email
        Glide.with(context).load(allDatasList[position].avatar).into(holder.itemAvatar!!)
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var itemViewHolder = itemView
        var itemName = itemViewHolder?.tv_name
        var itemAvatar = itemViewHolder?.img_avatar
        var itemMail = itemViewHolder?.tv_mail
    }

}
