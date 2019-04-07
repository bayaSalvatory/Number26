package com.tonny.core.blockchain

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BlockChainRepoImpl @Inject constructor(private val blockChainApi: BlockChainApi) :
    BlockChainRepo {
  override fun retrieveCharts(): Single<TransactionResponse> = blockChainApi.retrieveCharts()
      .subscribeOn(Schedulers.io())

}