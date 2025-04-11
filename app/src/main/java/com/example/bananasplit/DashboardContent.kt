package com.example.bananasplit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DashboardContent() {
    var searchQuery by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFF4F4F9))
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Teile deine Fahrt!",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color(0xFF5A3B18),
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Hier haben Sie die Möglichkeit:\n" +
                            "- Ihre Mitteilungen einzusehen,\n" +
                            "- Ihr Profil zu verwalten,\n" +
                            "- eine Wunschfahrt auszuwählen oder eine Mitfahrgelegenheit anzubieten\n",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Such deine Fahrt!",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color(0xFF5A3B18),
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Hier haben Sie die Möglichkeit, eine Fahrt zu suchen.",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Suche nach Stadt...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                )
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Neue Mitteilungen?",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color(0xFF5A3B18),
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Die Mitteilungsfunktion ermöglicht eine direkte und effiziente Kommunikation zwischen Fahrern und Mitfahrern. Hier erhalten Sie wichtige Benachrichtigungen zu Ihren Fahrten, Nachrichten von anderen Nutzern sowie Updates zu Anfragen oder Änderungen. Durch regelmäßiges Prüfen Ihrer Mitteilungen stellen Sie sicher, dass Sie keine relevanten Informationen verpassen und Ihre Fahrten reibungslos organisieren können.",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Mitteilungen",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF5A3B18),
                    modifier = Modifier.clickable { },
                    textAlign = TextAlign.Center
                )
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Pflege dein Profil!",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color(0xFF5A3B18),
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Bitte pflegen Sie Ihr Profil, um eine optimale Nutzung der Plattform zu gewährleisten. Ein vollständiges und aktuelles Profil erhöht Ihre Vertrauenswürdigkeit, erleichtert die Kommunikation mit Fahrern und Mitfahrern und trägt zu einer sicheren und angenehmen Erfahrung bei. Zudem können Sie so schneller passende Fahrten finden oder von anderen als zuverlässiger Fahrer wahrgenommen werden.",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Profil",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF5A3B18),
                    modifier = Modifier.clickable { },
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDashboardContent() {
    DashboardContent()
}
