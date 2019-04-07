package com.tonny.core.blockchain

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BlockChainApi {
  @GET("/charts/transactions-per-second")
  fun retrieveCharts(
    @Query("timespan") timeSpan: String = "5weeks",
    @Query("rollingAverage") rollingAverage: String = "8hours"
  ): Single<TransactionResponse>
}