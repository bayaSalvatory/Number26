package com.tonny.core.blockchain

import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class BlockChainRepoImplTest {

  @Mock lateinit var blockChainApi: BlockChainApi
  lateinit var blockChainRepoImpl: BlockChainRepoImpl

  @Before
  fun setUp() {
    MockitoAnnotations.initMocks(this)
    blockChainRepoImpl = BlockChainRepoImpl(blockChainApi)
  }

  @Test
  fun given_blockChainRepo_when_retrievingData_then_handleSuccess() {
    Mockito.`when`(blockChainApi.retrieveCharts())
        .thenReturn(Single.just(graphData))
    blockChainRepoImpl
        .retrieveCharts()
        .test()
        .assertNoErrors()
  }

  private val graphData by lazy {
    val coordinate = (0..3).map { Coordinate(it.toFloat(), (it + 3).toFloat()) }
    GraphData(
        "ok", "Confirmed Transactions Per Day",
        "Transactions", "day", "The number of daily confirmed Bitcoin transactions.",
        coordinate
    )
  }
}