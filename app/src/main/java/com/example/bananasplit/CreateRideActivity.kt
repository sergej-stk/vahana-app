package com.example.bananasplit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class CreateRideActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateRideContent(
                onRideCreated = { finish() },
                onBack = { finish() }
            )
        }
    }
}
