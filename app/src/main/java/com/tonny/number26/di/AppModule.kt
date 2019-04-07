package com.tonny.number26.di

import com.tonny.core.N26
import com.tonny.core.N26Impl
import com.tonny.number26.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [UiModule::class])
class AppModule {
  @Provides @Singleton fun provideN26(app: App): N26 = N26Impl(app)
}