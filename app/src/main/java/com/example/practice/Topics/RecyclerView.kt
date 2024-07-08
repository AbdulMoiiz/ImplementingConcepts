package com.example.practice.Topics

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice.R
import com.example.practice.databinding.ActivityRecyclerViewBinding

class RecyclerView : AppCompatActivity() {
    lateinit var dataBinding: ActivityRecyclerViewBinding
    var arrContacts:MutableList<ContactModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dataBinding=DataBindingUtil.setContentView(this, R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        arrContacts.add(ContactModel(R.drawable.g,"Moiz","233892832"))
        arrContacts.add(ContactModel(R.drawable.b,"Ali","1424324344"))
        arrContacts.add(ContactModel(R.drawable.d,"Ahmad","143355353"))
        arrContacts.add(ContactModel(R.drawable.e,"Khan","4255235551"))
        arrContacts.add(ContactModel(R.drawable.f,"Suhan","4343434343"))
        arrContacts.add(ContactModel(R.drawable.h,"Javed","2352353525"))
        arrContacts.add(ContactModel(R.drawable.ab,"Abdul","233892832"))
        arrContacts.add(ContactModel(R.drawable.g,"Moiz","233892832"))
        arrContacts.add(ContactModel(R.drawable.b,"Ali","1424324344"))
        arrContacts.add(ContactModel(R.drawable.d,"Ahmad","143355353"))
        arrContacts.add(ContactModel(R.drawable.e,"Khan","4255235551"))
        arrContacts.add(ContactModel(R.drawable.f,"Suhan","4343434343"))
        arrContacts.add(ContactModel(R.drawable.h,"Javed","2352353525"))
        arrContacts.add(ContactModel(R.drawable.ab,"Abdul","233892832"))


        dataBinding.recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter= RecyclerViewAdapter(this,arrContacts)
        dataBinding.recyclerView.adapter=adapter
    }
}