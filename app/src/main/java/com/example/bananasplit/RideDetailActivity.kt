package com.example.bananasplit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class RideDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rideId = intent.getIntExtra("rideId", 0)
        val ride = Ride(rideId, "Fahrt Detail", "Detailbeschreibung der Fahrt")
        setContent {
            RideDetailContent(ride = ride, onBack = { finish() })
        }
    }
}
