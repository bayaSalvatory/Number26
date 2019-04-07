package com.tonny.number26.di

import com.tonny.number26.di.scope.PerActivity
import com.tonny.number26.ui.charts.ChartsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

  @PerActivity
  @ContributesAndroidInjector
  abstract fun chartsActivityInjector() : ChartsActivity
}