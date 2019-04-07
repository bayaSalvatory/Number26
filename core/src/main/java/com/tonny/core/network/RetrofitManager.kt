package com.tonny.core.network

import retrofit2.Retrofit

interface RetrofitManager {
  fun getRetrofit(): Retrofit
}