class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        TokenManager.init(this)

        setContent {

            val navController =
                rememberNavController()

            NavHost(
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