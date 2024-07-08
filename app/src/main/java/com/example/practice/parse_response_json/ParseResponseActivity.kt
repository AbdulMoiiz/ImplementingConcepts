package com.example.practice.parse_response_json

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.example.practice.R
import com.example.practice.databinding.ActivityParceResponseBinding
import org.json.JSONArray
import org.json.JSONObject

class ParseResponseActivity : AppCompatActivity() {
    lateinit var binding: ActivityParceResponseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= DataBindingUtil.setContentView(this,R.layout.activity_parce_response)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val url = "https://jsonplaceholder.typicode.com/users"

        val array: ArrayList<String> = arrayListOf()

        AndroidNetworking.initialize(this)
        AndroidNetworking.get(url)
            .setPriority(Priority.HIGH)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {

                override fun onResponse(response: JSONArray) {
                    Log.d("TAG", "onResponse: $response")

                    for (i in 0 until response.length()){
                        val jsonObject: JSONObject = response.getJSONObject(i)
                        val name: String = jsonObject.getString("name")
                        array.add(name)
                    }

                    binding.listView.adapter= ArrayAdapter(this@ParseResponseActivity,android.R.layout.simple_list_item_1,array)

                }

                override fun onError(anError: ANError?) {
                    Log.e("TAG", "onError: ${anError.toString()}", )
                }

            })


    }


}