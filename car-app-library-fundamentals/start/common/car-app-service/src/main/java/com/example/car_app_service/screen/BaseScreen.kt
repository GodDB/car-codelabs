package com.example.car_app_service.screen

import android.util.Log
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.lifecycle.Lifecycle

abstract class BaseScreen(_carContext: CarContext) : Screen(_carContext) {

    override fun dispatchLifecycleEvent(event: Lifecycle.Event) {
        super.dispatchLifecycleEvent(event)

        Log.e("godgod", "$this dispatchLifecycleEvent  ${event}")
    }

}
