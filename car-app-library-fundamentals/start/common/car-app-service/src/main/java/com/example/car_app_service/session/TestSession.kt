package com.example.car_app_service.session

import android.content.Intent
import android.content.res.Configuration
import android.util.Log
import androidx.car.app.Screen
import androidx.car.app.Session
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.car_app_service.screen.MainScreen

internal class TestSession : Session(), DefaultLifecycleObserver {

    init {
        lifecycle.addObserver(this)
    }

    override fun onCreateScreen(intent: Intent): Screen {
        Log.e("godgod", "$this onCreateScreen   ${intent.extras}")
        return MainScreen(carContext)
    }

    override fun onNewIntent(intent: Intent) {
        Log.e("godgod", "$this onNewIntent   ${intent.extras}")
    }

    override fun onCarConfigurationChanged(newConfiguration: Configuration) {
        Log.e("godgod", "$this onCarConfigurationChanged   ${newConfiguration}")
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.e("godgod", "$this onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.e("godgod", "$this onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.e("godgod", "$this onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.e("godgod", "$this onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.e("godgod", "$this onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.e("godgod", "$this onDestroy")
    }
}
