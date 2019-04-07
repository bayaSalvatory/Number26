package com.tonny.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class N26Module(private val context: Context) {
  @Provides
  @Singleton
  fun provideContext(): Context {
    return this.context
  }
}