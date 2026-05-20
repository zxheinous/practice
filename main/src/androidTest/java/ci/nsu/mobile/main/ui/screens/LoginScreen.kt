@Composable
fun LoginScreen(
    viewModel: AuthViewModel,
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit
) {

    var login by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement =
            Arrangement.Center
    ) {

        OutlinedTextField(
            value = login,
            onValueChange = {
                login = it
            },
            label = {
                Text("Логин")
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Пароль")
            },
            visualTransformation =
                PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.login(
                    login,
                    password,
                    onLoginSuccess
                )
            }
        ) {
            Text("Войти")
        }

        TextButton(
            onClick = onRegisterClick
        ) {
            Text("Нет аккаунта?")
        }

        if (viewModel.isLoading) {
            CircularProgressIndicator()
        }

        viewModel.error?.let {
            Text(it)
        }
    }
}