package com.example.sample.base

import android.app.Application
import android.content.res.Resources
import com.example.sample.repository.Repository

class ViewModelFactory(
    override var mApplication: Application?,
    override var mRepository: Repository?,
    override var mPreferences: SharedPreferencesProvider?,
    override var mResource: Resources?
): BaseViewModelFactory() {
    override fun init(
        application: Application,
        repository: Repository,
        preferences: SharedPreferencesProvider,
        resource: Resources
    ) {
    }
}