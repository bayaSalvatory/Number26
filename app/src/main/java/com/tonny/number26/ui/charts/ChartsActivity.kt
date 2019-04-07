package com.tonny.number26.ui.charts

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tonny.number26.R
import com.tonny.number26.databinding.ActivityChartsBinding
import com.tonny.number26.ui.base.BaseActivity

class ChartsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityChartsBinding>(this, R.layout.activity_charts)
        binding.viewModel = MainActivityViewModel()
    }
}
