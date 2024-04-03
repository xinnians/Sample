package com.example.sample.page.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample.repository.NetworkModule
import com.example.sample.repository.model.CountryCodeList
import com.skydoves.sandwich.onError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import com.example.sample.repository.model.Result
import com.skydoves.sandwich.getOrThrow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class SplashViewModel : ViewModel() {
    private val _data = MutableStateFlow<Result<CountryCodeList>>(Result.Loading)
    val data: StateFlow<Result<CountryCodeList>> = _data

    fun getCountryCodeList() {
        viewModelScope.launch {
            _data.value = Result.Loading
            try {
                val response = NetworkModule.provideApiService().getCountryList()
                _data.value = Result.Success(response.getOrThrow())
            } catch (e: Exception) {
                _data.value = Result.Error(e)
            }
        }
    }
}