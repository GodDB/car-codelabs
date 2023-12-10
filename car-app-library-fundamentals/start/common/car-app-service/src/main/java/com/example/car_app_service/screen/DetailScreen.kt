package com.example.car_app_service.screen

import androidx.car.app.CarContext
import androidx.car.app.model.Action
import androidx.car.app.model.CarIcon
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.core.graphics.drawable.IconCompat
import com.example.android.cars.carappservice.R
import com.example.car_app_service.Navigator
import com.example.places.data.PlacesRepository


internal class DetailScreen(
    carContext: CarContext,
    private var placeId: Int
) : BaseScreen(carContext) {
    override fun onGetTemplate(): Template {
        val place = PlacesRepository().getPlace(placeId)
            ?: return MessageTemplate.Builder("Place not found")
                .setHeaderAction(Action.BACK)
                .build()

        val navigateAction = Action.Builder()
            .setTitle("Navigate")
            .setIcon(
                CarIcon.Builder(
                    IconCompat.createWithResource(
                        carContext,
                        R.drawable.baseline_navigation_24
                    )
                ).build()
            )
            // Only certain intent actions are supported by `startCarApp`. Check its documentation
            // for all of the details. To open another app that can handle navigating to a location
            // you must use the CarContext.ACTION_NAVIGATE action and not Intent.ACTION_VIEW like
            // you might on a phone.
            .setOnClickListener {
                Navigator.moveToMain(screenManager, carContext)
                // carContext.startCarApp(place.toIntent(CarContext.ACTION_NAVIGATE))
            }
            .build()

        return PaneTemplate.Builder(
            Pane.Builder()
                .addAction(navigateAction)
                .addRow(
                    Row.Builder()
                        .setTitle("Coordinates")
                        .addText("${place.latitude}, ${place.longitude}")
                        .build()
                ).addRow(
                    Row.Builder()
                        .setTitle("Description")
                        .addText(place.description)
                        .build()
                ).build()
        )
            .setTitle(place.name)
            .setHeaderAction(Action.BACK)
            .build()
    }
}
