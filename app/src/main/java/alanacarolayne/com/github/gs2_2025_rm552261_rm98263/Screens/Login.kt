package alanacarolayne.com.github.gs2_2025_rm552261_rm98263.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Login(modifier: Modifier = Modifier, navController: NavController) {

    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val errorMessage = remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFC5F3C8))
            .padding(32.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = "LOGIN",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(32.dp))


            OutlinedTextField(
                value = username.value,
                onValueChange = { username.value = it },
                label = { Text("Usuário") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = errorMessage.value.isNotEmpty(),
                colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(16.dp))


            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Senha") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(),
                isError = errorMessage.value.isNotEmpty(),
                colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(16.dp))


            if (errorMessage.value.isNotEmpty()) {
                Text(
                    text = errorMessage.value,
                    color = Color.Red,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


            Button(
                onClick = {

                    if (username.value == "admin" && password.value == "123456") {

                        navController.navigate("menu")
                    } else {

                        errorMessage.value = "Usuário ou senha inválidos"
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "ENTRAR",
                    fontSize = 20.sp,
                    color = Color.Green
                )
            }
        }
    }
}
