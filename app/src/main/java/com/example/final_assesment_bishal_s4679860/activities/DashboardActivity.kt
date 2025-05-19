package com.example.final_assesment_bishal_s4679860.activities

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.final_assesment_bishal_s4679860.R
import com.example.final_assesment_bishal_s4679860.adapter.MyAdapter
import com.example.final_assesment_bishal_s4679860.api.ApiClient
import com.example.final_assesment_bishal_s4679860.api.ApiService
import com.example.final_assesment_bishal_s4679860.models.DashboardResponse
import com.example.final_assesment_bishal_s4679860.models.EntityDetails
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {
    @Inject
    lateinit var apiService: ApiService
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter
    private var currentIndex = 0 // Track current index

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // list of images
        val imageList = listOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7
        )
        // Set up RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

       // Initialize Retrofit
      //val retrofit = ApiClient.getRetrofitInstance()
      //val apiService = retrofit.create(ApiService::class.java)

        // Get API data
        apiService.getEntities().enqueue(object : Callback<DashboardResponse> {
            override fun onResponse(call: Call<DashboardResponse>, response: Response<DashboardResponse>) {
                if (response.isSuccessful) {
                    val dashboardResponse = response.body()
                    val entityList = dashboardResponse?.entities ?: emptyList()
                    if (entityList.isEmpty()) {
                        Log.e("DashboardActivity", "Received empty entity list from API")
                    } else {
                        adapter = MyAdapter(imageList, entityList)
                        recyclerView.adapter = adapter
                    }
                } else {
                    // Handle response error
                    Log.e("DashboardActivity", "API response error: ${response.code()} ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                // Handle network failure
                Log.e("DashboardActivity", "Network error: ${t.message}", t)
            }
        })

        // Get Next and Previous buttons
        val nextButton: ImageButton = findViewById(R.id.right_arrow)
        val prevButton: ImageButton = findViewById(R.id.left_arrow)

        // Next Button: Scroll to next item
        nextButton.setOnClickListener {
            if (currentIndex < imageList.size - 1) {
                currentIndex++
                recyclerView.smoothScrollToPosition(currentIndex)
            }
        }

        // Previous Button: Scroll to previous item
        prevButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                recyclerView.smoothScrollToPosition(currentIndex)
            }
        }
    }
}
