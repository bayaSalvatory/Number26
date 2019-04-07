package com.tonny.number26.ui.binding

import androidx.databinding.BindingAdapter
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.tonny.core.blockchain.Coordinate

object ChartBinding {

  @JvmStatic
  @BindingAdapter("coordinates")
  fun bindChart(
    chart: LineChart,
    data: List<Coordinate>
  ) {
    val entries = data.map { Entry(it.x, it.y) }
    val dataSet = LineDataSet(entries, "N26")
    val lineData = LineData(dataSet)
    chart.data = lineData
    chart.invalidate()
  }
}