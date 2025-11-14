package alanacarolayne.com.github.gs2_2025_rm552261_rm98263

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import alanacarolayne.com.github.gs2_2025_rm552261_rm98263.Screens.Equipe
import alanacarolayne.com.github.gs2_2025_rm552261_rm98263.Screens.IMC
import alanacarolayne.com.github.gs2_2025_rm552261_rm98263.Screens.Login
import alanacarolayne.com.github.gs2_2025_rm552261_rm98263.Screens.Menu
import alanacarolayne.com.github.gs2_2025_rm552261_rm98263.ui.theme.GS2_2025_RM552261_RM98263Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GS2_2025_RM552261_RM98263Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        modifier = Modifier.padding(innerPadding)
                    ) {

                        composable(route = "login") {
                            Login(navController = navController)
                        }
                        composable(route = "menu") {
                            Menu(navController = navController)
                        }


                        composable(route = "imc") {
                            IMC(modifier = Modifier.padding(innerPadding), navController = navController)
                        }

                        composable(route = "equipe") {
                            Equipe(modifier = Modifier.padding(innerPadding), navController = navController)
                        }
                    }
                }
            }
        }
    }
}
