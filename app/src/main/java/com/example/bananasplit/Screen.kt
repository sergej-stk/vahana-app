package com.example.bananasplit

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.bananasplit.R

sealed class Screen(val route: String, val label: String, val icon: @Composable () -> Unit) {
    object Dashboard : Screen(
        route = "dashboard",
        label = "Dashboard",
        icon = { Icon(painterResource(id = R.drawable.ic_dashboard), contentDescription = "Dashboard") }
    )
    object Fahrten : Screen(
        route = "fahrten",
        label = "Fahrten",
        icon = { Icon(painterResource(id = R.drawable.ic_fahrten), contentDescription = "Fahrten") }
    )
    object Settings : Screen(
        route = "settings",
        label = "Settings",
        icon = { Icon(painterResource(id = R.drawable.ic_settings), contentDescription = "Settings") }
    )
}
