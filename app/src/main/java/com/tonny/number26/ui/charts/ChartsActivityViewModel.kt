package com.tonny.number26.ui.charts

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.tonny.core.N26
import com.tonny.core.blockchain.Coordinate
import com.tonny.number26.di.scope.PerActivity
import com.tonny.number26.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@PerActivity
class ChartsActivityViewModel @Inject constructor(private val n26: N26) : BaseViewModel() {
  val coordinates = ObservableField<List<Coordinate>>(ArrayList())
  val showProgress = ObservableBoolean(false)

  fun loadChart() {
    showProgress.set(true)
    disposables.add(
        n26.getBlockChainRepo()
            .retrieveCharts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
              showProgress.set(false)
              coordinates.set(it.values)
            }, { showProgress.set(false) })
    )
  }

  fun stop() {
    disposables.clear()
  }

}