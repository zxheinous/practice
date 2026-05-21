

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

class MainActivity : androidx.activity.ComponentActivity() {

    override fun onCreate(
        savedInstanceState: android.os.Bundle?
    ) {

        super.onCreate(savedInstanceState)

        TokenManager.init(this)

        setContent {

            val navController =
                androidx.navigation.compose.rememberNavController()

            androidx.navigation.compose.NavHost(
                navController = navController,
                startDestination = "login"
            ) {

                composable("login") {

                    LoginScreen(
                        viewModel = AuthViewModel(
                            AuthRepository()
                        ),
                        onLoginSuccess = {
                            navController.navigate("home")
                        },
                        onRegisterClick = {
                            navController.navigate(
                                "register"
                            )
                        }
                    )
                }

                composable("home") {
                    // HomeScreen
                }

                composable("register") {
                    // RegisterScreen
                }
            }
        }
    }
}

private fun MainActivity.composable(string: String, function: () -> Unit) {
    kotlin.TODO("Not yet implemented")
}
