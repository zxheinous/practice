package ci.nsu.mobile.main.data.api

import ci.nsu.mobile.main.data.storage.TokenManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(
        chain: Interceptor.Chain
    ): Response {

        val original = chain.request()

        val builder = original.newBuilder()

        builder.addHeader(
            "Content-Type",
            "application/json"
        )

        TokenManager.token?.let {
            builder.addHeader(
                "Authorization",
                "Bearer $it"
            )
        }

        return chain.proceed(builder.build())
    }
}