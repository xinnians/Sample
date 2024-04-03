package com.example.sample.repository.model

import com.google.gson.annotations.SerializedName

data class BaseData(
    val code: Int,
    val msg: String
)

data class ApiResponse<T>(
    val status: String,
    val message: String?,
    val data: T
)

data class CountryCode(
    @SerializedName("Code")
    val code: String,
    @SerializedName("CnName")
    val cnName: String,
    @SerializedName("EnName")
    val enName: String,
    @SerializedName("TelCode")
    val telCode: String
)

data class CountryCodeList(
    @SerializedName("Data")
    val countryList: List<CountryCode>,
    val baseData: BaseData
)
