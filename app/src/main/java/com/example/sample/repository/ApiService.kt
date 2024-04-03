package com.example.sample.repository

import com.example.sample.repository.model.CountryCodeList
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("GetCountryList")
    suspend fun getCountryList(): ApiResponse<CountryCodeList>
}