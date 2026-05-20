class AuthRepository {

    private val api = RetrofitClient.api

    suspend fun login(
        login: String,
        password: String
    ): Result<Unit> {

        return try {

            val response = api.login(
                LoginRequest(login, password)
            )

            TokenManager.token = response.token

            Result.success(Unit)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun register(
        request: RegisterRequest
    ): Result<Unit> {

        return try {

            api.register(request)

            Result.success(Unit)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUsers():
            Result<List<UserDto>> {

        return try {

            Result.success(api.getUsers())

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getGroups():
            Result<List<GroupDto>> {

        return try {

            Result.success(api.getGroups())

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}