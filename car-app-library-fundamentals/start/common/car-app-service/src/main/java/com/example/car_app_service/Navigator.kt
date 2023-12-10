package com.example.car_app_service

import androidx.car.app.CarContext
import androidx.car.app.ScreenManager
import com.example.car_app_service.screen.DetailScreen

object Navigator {

    fun moveToMain(screenManager: ScreenManager, carContext: CarContext) {
        screenManager.popToRoot()
    }

    fun moveToDetail(screenManager: ScreenManager, carContext: CarContext, id: Int) {
        val screen = DetailScreen(carContext, id)
        screenManager.push(screen)
    }
}
