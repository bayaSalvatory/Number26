package com.tonny.core.di

import com.tonny.core.blockchain.BlockChainRepo
import com.tonny.core.blockchain.BlockChainRepoImpl
import com.tonny.core.network.RetrofitManager
import com.tonny.core.network.RetrofitManagerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [(ApiModule::class)])
abstract class ConfigModule {
    @Singleton
    @Binds
    abstract fun bindRetrofitManager(impl: RetrofitManagerImpl): RetrofitManager

    @Singleton
    @Binds
    abstract fun bindBlockChainRepo(impl: BlockChainRepoImpl): BlockChainRepo
}