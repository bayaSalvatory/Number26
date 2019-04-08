package com.tonny.core.network

import retrofit2.Retrofit

interface RetrofitManager {

  /**
   * Use to get an instance of [Retrofit]
   * <p>
   * Retrofit turns your HTTP API into a Java interface
   *
   * @return [Retrofit]
   */
  fun getRetrofit(): Retrofit
}