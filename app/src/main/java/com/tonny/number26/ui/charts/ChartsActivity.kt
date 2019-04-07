package com.tonny.number26.ui.charts

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tonny.number26.R
import com.tonny.number26.databinding.ActivityChartsBinding
import com.tonny.number26.ui.base.BaseActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class ChartsActivity : BaseActivity() {

  @Inject lateinit var viewModel: ChartsActivityViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    val binding =
      DataBindingUtil.setContentView<ActivityChartsBinding>(this, R.layout.activity_charts)
    binding.viewModel = viewModel
  }

  override fun onStart() {
    super.onStart()
    viewModel.loadChart()
  }

  override fun onStop() {
    super.onStop()
    viewModel.stop()
  }
}
