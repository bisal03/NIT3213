package com.example.final_assesment_bishal_s4679860.api
import com.example.final_assesment_bishal_s4679860.models.DashboardResponse
import com.example.final_assesment_bishal_s4679860.models.EntityDetails
import com.example.final_assesment_bishal_s4679860.models.LoginRequest
import com.example.final_assesment_bishal_s4679860.models.LoginResponse
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
//    Login endpoints
    @POST("/sydney/auth")
    fun userLogin(@Body loginRequest: LoginRequest): Call<LoginResponse>

//    Dashboard endpoints
    @GET("/dashboard/animals")
    fun getEntities(): Call<DashboardResponse>
}