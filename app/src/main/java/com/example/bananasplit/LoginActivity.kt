package com.example.bananasplit

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BananaSplitTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F9))
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Login",
                    style = TextStyle(
                        color = Color(0xFF5A3B18),
                        fontSize = 30.sp
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("E-Mail") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("Passwort") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Button(
                    onClick = {
                        context.startActivity(Intent(context, DashboardActivity::class.java))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5A3B18),
                        contentColor = Color(0xFFF8E71C)
                    )
                ) {
                    Text("Login")
                }

                Text(
                    text = "Passwort vergessen?",
                    color = Color(0xFF5A3B18),
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .clickable {
                            context.startActivity(Intent(context, ResetPasswordActivity::class.java))
                        }
                )

                Text(
                    text = "Registrieren",
                    color = Color(0xFF5A3B18),
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .clickable {
                            context.startActivity(Intent(context, RegisterActivity::class.java))
                        }
                )
            }
        }
    }
}
