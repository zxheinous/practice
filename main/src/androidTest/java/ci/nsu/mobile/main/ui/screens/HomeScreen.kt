@Composable
fun HomeScreen(
    users: List<UserDto>,
    onLogout: () -> Unit
) {

    Column {

        Button(
            onClick = onLogout
        ) {
            Text("Выйти")
        }

        LazyColumn {

            items(users) { user ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {

                        Text(user.login)
                        Text(user.email)
                    }
                }
            }
        }
    }
}