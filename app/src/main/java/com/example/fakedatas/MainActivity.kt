package com.example.fakedatas

import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Display
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.fakedatas.adapter.MainActivityAdapter
import com.example.fakedatas.datas.Data
import com.example.fakedatas.datas.Model
import com.example.fakedatas.singleton.ApiClient
import com.example.fakedatas.singleton.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val allDatas: MutableList<Data> = mutableListOf()
    private lateinit var myAdapter: MainActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup Adapter
        myAdapter = MainActivityAdapter(allDatas)

        //setup recyclerview
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        myRecyclerView.adapter = myAdapter

        //setup Android Networking
        AndroidNetworking.initialize(this)

        AndroidNetworking.get("https://reqres.in/api/users?page=2")
            .build()
            .getAsObject(Model::class.java, object : ParsedRequestListener<Model>{
                override fun onResponse(response: Model?) {
                    allDatas.addAll(response?.data!!)
                    myAdapter.notifyDataSetChanged()
                }

                override fun onError(anError: ANError?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })

    }
}
