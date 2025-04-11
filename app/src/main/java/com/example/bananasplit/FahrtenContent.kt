package com.example.bananasplit

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

data class Ride(val id: Int, val title: String, val description: String)

@Composable
fun FahrtenContent(
    onCreateRideClick: () -> Unit = {},
    onRideClick: (Ride) -> Unit = {}
) {
    val context = LocalContext.current
    val rides = listOf(
        Ride(1, "Fahrt 1: Berlin nach Hamburg", "Erlebe eine entspannte Fahrt zwischen Berlin und Hamburg."),
        Ride(2, "Fahrt 2: München nach Stuttgart", "Schnelle Verbindung zwischen München und Stuttgart."),
        Ride(3, "Fahrt 3: Köln nach Düsseldorf", "Komfortable Reise von Köln nach Düsseldorf."),
        Ride(4, "Fahrt 4: Frankfurt nach Mainz", "Kulturelle Tour zwischen Frankfurt und Mainz.")
    )
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF4F4F9))
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Mitfahrzentrale",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFF5A3B18)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Finde Fahrten, die zu deinem Ziel führen oder erstelle deine eigene Fahrt.",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF5A3B18),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    context.startActivity(Intent(context, CreateRideActivity::class.java))
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5A3B18),
                    contentColor = Color(0xFFF8E71C)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Fahrt erstellen", style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 280.dp),
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(rides) { ride ->
                        RideCard(ride = ride, onClick = {
                            val intent = Intent(context, RideDetailActivity::class.java)
                            intent.putExtra("rideId", ride.id)
                            context.startActivity(intent)
                        })
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5A3B18),
                        contentColor = Color(0xFFF8E71C)
                    )
                ) {
                    Text(text = "<")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Seite 1 von 1", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5A3B18),
                        contentColor = Color(0xFFF8E71C)
                    )
                ) {
                    Text(text = ">")
                }
            }
        }
    }
}

@Composable
fun RideCard(ride: Ride, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row {
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .fillMaxHeight()
                    .background(Color(0xFFFFD700))
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = ride.title, style = MaterialTheme.typography.titleMedium, color = Color(0xFF5A3B18))
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = ride.description, style = MaterialTheme.typography.bodyMedium, color = Color(0xFF555555))
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1A73E8),
                        contentColor = Color.White
                    ),
                    modifier = Modifier.height(36.dp)
                ) {
                    Text(text = "Fahrt beitreten", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFahrtenContent() {
    FahrtenContent()
}
