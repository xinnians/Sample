package com.example.sample

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

class MyApplication : Application(), ViewModelStoreOwner {
    override val viewModelStore: ViewModelStore
        get() = ViewModelStore()


}