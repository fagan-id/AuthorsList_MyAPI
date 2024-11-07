package com.example.authorslist_myapi

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.authorslist_myapi.databinding.ActivityMainBinding
import com.example.authorslist_myapi.model.Authors
import com.example.authorslist_myapi.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val responseAuthors = client.getAllAuthors()
        val authorList = ArrayList<String>()


        responseAuthors.enqueue(object : Callback<List<Authors>> {
            override fun onResponse(p0: Call<List<Authors>>, p1: Response<List<Authors>>) {
                for (i in p1.body()!!) {
                    authorList.add(i.fullName)
                }

                val ListAdapter = ArrayAdapter(
                    this@MainActivity,
                    android.R.layout.simple_list_item_1,
                    authorList
                )
                binding.lvNama.adapter = ListAdapter
            }

            override fun onFailure(p0: Call<List<Authors>>, p1: Throwable) {
                Toast.makeText(this@MainActivity, "Connection Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}