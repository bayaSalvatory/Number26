package com.tonny.number26.ui.charts

import androidx.databinding.ObservableField
import com.tonny.core.N26
import com.tonny.core.blockchain.Coordinate
import com.tonny.number26.di.scope.PerActivity
import com.tonny.number26.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@PerActivity
class ChartsActivityViewModel @Inject constructor(private val n26: N26) : BaseViewModel() {
  val coordinate = ObservableField<String>()
  val coordinates = ObservableField<List<Coordinate>>(ArrayList())

  fun start() {
    disposables.add(
        n26.blockChainRepo.retrieveCharts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ processGraphData(it.values) }, {})
    )
  }

  fun stop() {
    disposables.clear()
  }

  private fun processGraphData(data: List<Coordinate>) {
    coordinates.set(data)
    val coordinates = StringBuilder()
    data.forEach {
      coordinates.append("${it.x}, ${it.y}")
    }
    this.coordinate.set(coordinates.toString())
  }
}