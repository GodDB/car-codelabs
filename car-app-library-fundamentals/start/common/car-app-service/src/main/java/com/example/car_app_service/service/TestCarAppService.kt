package com.example.car_app_service.service

import android.content.Intent
import android.content.pm.ApplicationInfo
import android.util.Log
import androidx.car.app.CarAppService
import androidx.car.app.Session
import androidx.car.app.validation.HostValidator
import com.example.car_app_service.session.TestSession

class TestCarAppService : CarAppService() {
    override fun createHostValidator(): HostValidator {
        Log.e("godgod", "$this createHostValidator")
        return if (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0) {
            HostValidator.ALLOW_ALL_HOSTS_VALIDATOR
        } else {
            HostValidator.Builder(applicationContext)
                .addAllowedHosts(androidx.car.app.R.array.hosts_allowlist_sample)
                .build()
        }
    }

    override fun onCreateSession(): Session {
        Log.e("godgod", "$this onCreateSession")
        return TestSession()
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("godgod", "$this onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("godgod", "$this onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e("godgod", "$this onDestroy")
    }
}
