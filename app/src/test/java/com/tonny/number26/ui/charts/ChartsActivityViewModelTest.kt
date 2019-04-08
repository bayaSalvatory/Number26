package com.tonny.number26.ui.charts

import com.tonny.core.N26
import com.tonny.core.blockchain.BlockChainRepo
import com.tonny.core.blockchain.Coordinate
import com.tonny.core.blockchain.GraphData
import io.github.plastix.rxschedulerrule.RxSchedulerRule
import io.reactivex.Single
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ChartsActivityViewModelTest {

  @Mock lateinit var n26: N26
  @Mock lateinit var blockChainRepo: BlockChainRepo
  private lateinit var viewModel: ChartsActivityViewModel

  @get:Rule
  val schedulerRule = RxSchedulerRule()

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)
    Mockito.`when`(n26.getBlockChainRepo())
        .thenReturn(
            blockChainRepo
        )

    Mockito.`when`(blockChainRepo.retrieveCharts())
        .thenReturn(
            Single.just(graphData)
        )
    viewModel = ChartsActivityViewModel(n26)
  }

  @Test
  fun given_viewModel_when_chartLoaded_then_hideProgressBar() {
    viewModel.loadChart()
    assertFalse(viewModel.showProgress.get())
  }

  @Test
  fun given_viewModel_when_chartLoaded_then_verifyCoordinateDat() {
    viewModel.loadChart()
    assert(!viewModel.coordinates.get()?.isEmpty()!!)
  }

  @Test
  fun stop() {
    assert(viewModel.disposables.size() <= 0)
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