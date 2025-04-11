package com.example.bananasplit

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bananasplit.ui.theme.BananaSplitTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BananaSplitTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    RegisterScreen()
                }
            }
        }
    }
}

@Composable
fun RegisterScreen() {
    val context = LocalContext.current

    val scrollState = rememberScrollState()

    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F9))
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            color = Color.White
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                Button(
                    onClick = { (context as? Activity)?.finish() },
                    modifier = Modifier.wrapContentWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color(0xFF5A3B18)
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
                ) {
                    Text("Zurück")
                }

                Text(
                    text = "Registrierung",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    style = TextStyle(
                        color = Color(0xFF5A3B18),
                        fontSize = 24.sp
                    )
                )

                TextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("E-Mail-Adresse") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                TextField(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = { Text("Benutzername") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("Passwort") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                TextField(
                    value = repeatPassword,
                    onValueChange = { repeatPassword = it },
                    placeholder = { Text("Passwort wiederholen") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Button(
                    onClick = {
                        if (password.isNotEmpty() && password == repeatPassword) {
                            Toast.makeText(context, "Registrierung erfolgreich", Toast.LENGTH_SHORT)
                                .show()
                            (context as? Activity)?.finish()
                        } else {
                            Toast.makeText(context, "Passwörter stimmen nicht überein", Toast.LENGTH_SHORT)
                                .show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5A3B18),
                        contentColor = Color(0xFFF8E71C)
                    )
                ) {
                    Text("Registrieren")
                }
            }
        }
    }
}

@Composable
fun PreviewRegisterScreen() {
    BananaSplitTheme {
        RegisterScreen()
    }
}
