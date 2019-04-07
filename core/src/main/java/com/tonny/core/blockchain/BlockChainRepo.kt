package com.tonny.core.blockchain

import io.reactivex.Single

interface BlockChainRepo {
    fun retrieveCharts() : Single<TransactionResponse>
}