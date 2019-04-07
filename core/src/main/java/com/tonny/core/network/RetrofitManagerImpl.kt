package com.tonny.core.network

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RetrofitManagerImpl @Inject constructor(private val context: Context) : RetrofitManager {

  private var retrofit: Retrofit? = null

  override fun getRetrofit(): Retrofit {
    if (retrofit == null) {
      synchronized(RetrofitManager::class.java) {
        if (retrofit == null) {
          val httpLoggingInterceptor = HttpLoggingInterceptor()
          httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

          val cacheFile = File(context.cacheDir, "cache")
          val cache = Cache(cacheFile, 1024 * 1024 * 50) // 50Mb

          val client = OkHttpClient.Builder()
              .addInterceptor(httpLoggingInterceptor)
              .cache(cache)
              .connectTimeout(60L, TimeUnit.SECONDS)
              .readTimeout(60L, TimeUnit.SECONDS)
              .writeTimeout(60L, TimeUnit.SECONDS)
              .build()

          retrofit = Retrofit.Builder()
              .baseUrl(NetworkConfig.BASE_URL)
              .client(client!!)
              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
              .addConverterFactory(MoshiConverterFactory.create())
              .build()
        }
      }
    }
    return retrofit!!
  }
}