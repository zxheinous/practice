package ci.nsu.mobile.main.data.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object RetrofitClient {

    private const val BASE_URL =
        "http://192.168.200.160:8080/api/"

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor())
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()

    val api: ApiService by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttp)
            .addConverterFactory(
                json.asConverterFactory(
                    "application/json"
                        .toMediaType()
                )
            )
            .build()
            .create(ApiService::class.java)
    }
}