package com.tonny.number26

import android.app.Activity
import android.app.Application
import com.tonny.number26.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

  @Inject
  lateinit var activityInjector: DispatchingAndroidInjector<Activity>

  override fun onCreate() {
    super.onCreate()
    DaggerAppComponent.builder().create(this).inject(this)
  }

  override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}