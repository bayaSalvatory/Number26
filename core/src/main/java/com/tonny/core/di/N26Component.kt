package com.tonny.core.di

import android.content.Context
import com.tonny.core.N26
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [N26Module::class, ConfigModule::class])
interface N26Component {
  fun context(): Context

  fun inject(n26: N26)
}