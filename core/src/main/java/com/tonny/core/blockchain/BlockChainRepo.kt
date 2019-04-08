package com.tonny.core.blockchain

import io.reactivex.Single

interface BlockChainRepo {

  /**
   * Retrieves transaction data points to be used to populate a graph/chart.
   *
   * @return [Single] of [GraphData] that contains the retrieved data.
   */
  fun retrieveCharts(): Single<GraphData>
}