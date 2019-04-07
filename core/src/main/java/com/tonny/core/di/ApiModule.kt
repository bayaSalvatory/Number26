package com.tonny.core.di

import com.tonny.core.blockchain.BlockChainApi
import com.tonny.core.network.RetrofitManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideBlockChainApi(retrofitManager: RetrofitManager): BlockChainApi {
        return retrofitManager.getRetrofit().create(BlockChainApi::class.java)
    }
}