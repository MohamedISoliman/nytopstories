package io.github.mohamedisoliman.nytopstories.data.remote

import io.github.mohamedisoliman.nytopstories.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Mohamed Ibrahim on 7/31/18.
 */
object RemotesDataFactory {

    private const val BASE_URL = "https://api.nytimes.com/svc/"

    fun nytApis(): RemoteNyTimesContract {

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            //there's a problem with Moshi serializer
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(RemoteNyTimesContract::class.java)
    }

    private val okHttpClient: OkHttpClient
        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val clientBuilder = OkHttpClient.Builder()
                .addInterceptor(TokenInterceptor())
                .addInterceptor(loggingInterceptor)
            return clientBuilder.build()
        }

}


class TokenInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        val token = BuildConfig.API_KEY
        val url = original.url.newBuilder().addQueryParameter("api-key", token).build()
        original = original.newBuilder().url(url).build()
        return chain.proceed(original)
    }
}
