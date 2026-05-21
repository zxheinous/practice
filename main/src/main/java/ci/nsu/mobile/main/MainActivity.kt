package ci.nsu.mobile.main

import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import ci.nsu.mobile.main.data.repository.AuthRepository

import ci.nsu.mobile.main.data.storage.TokenManager
import ci.nsu.mobile.main.screens.LoginScreen
import ci.nsu.mobile.main.ui.viewmodel.AuthViewModel

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

private fun MainActivity.composable(string: String, function: @Composable () -> Unit) {
    kotlin.TODO("Not yet implemented")
}
