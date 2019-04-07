package com.tonny.core

import android.content.Context
import com.tonny.core.blockchain.BlockChainRepo
import com.tonny.core.di.DaggerN26Component
import com.tonny.core.di.N26Module
import javax.inject.Inject

class N26Impl(context: Context) : N26 {

  @Inject internal lateinit var blockChainRepo: BlockChainRepo

  init {
    DaggerN26Component.builder()
        .n26Module(N26Module(context))
        .build()
        .inject(this)
  }

  override fun getBlockChainRepo(): BlockChainRepo = blockChainRepo
}