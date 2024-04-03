package com.example.sample.page.splash

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.sample.databinding.ActivitySplashBinding
import com.example.sample.page.base.BaseActivity
import kotlinx.coroutines.launch
import com.example.sample.repository.model.Result


class SplashActivity : BaseActivity(){

    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeData()
        viewModel.getCountryCodeList()
    }

    private fun observeData(){
        lifecycleScope.launch {
            viewModel.data.collect { result ->
                when (result) {
                    is Result.Success -> {
                        // 处理成功的情况
                        val data = result.data
                        Log.e("Ian", "data: $data")
                    }
                    is Result.Error -> {
                        // 处理失败的情况
                        val error = result.exception
                        Log.e("Ian", "error: $error")
                    }
                    Result.Loading -> {
                        // 显示加载中状态
                        Log.e("Ian", "Loading")
                    }
                }
            }
        }
    }

}