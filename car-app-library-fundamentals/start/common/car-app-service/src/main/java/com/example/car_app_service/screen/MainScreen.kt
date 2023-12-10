package com.example.car_app_service.screen

import android.text.Spannable
import android.text.SpannableString
import androidx.car.app.CarContext
import androidx.car.app.model.Distance
import androidx.car.app.model.DistanceSpan
import androidx.car.app.model.ItemList
import androidx.car.app.model.PlaceListMapTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import com.example.car_app_service.Navigator
import com.example.places.data.PlacesRepository

internal class MainScreen(carContext: CarContext) : BaseScreen(carContext) {
    override fun onGetTemplate(): Template {
        val placesRepository = PlacesRepository()
        val itemListBuilder = ItemList.Builder()
            .setNoItemsMessage("No places to show")

        placesRepository.getPlaces()
            .forEach {
                itemListBuilder.addItem(
                    Row.Builder()
                        .setTitle(it.name)
                        // Each item in the list *must* have a DistanceSpan applied to either the title
                        // or one of the its lines of text (to help drivers make decisions)
                        .addText(SpannableString(" ").apply {
                            setSpan(
                                DistanceSpan.create(
                                    Distance.create(Math.random() * 100, Distance.UNIT_KILOMETERS)
                                ), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                            )
                        })
                        .setOnClickListener {
                            Navigator.moveToDetail(screenManager, carContext, it.id)
                        }
                        .build()
                )
            }

        return PlaceListMapTemplate.Builder()
            .setTitle("나는 갓이다")
            .setItemList(itemListBuilder.build())
            .build()
    }
}
