package com.tonny.core

import com.tonny.core.blockchain.BlockChainRepo

interface N26 {
  fun getBlockChainRepo() : BlockChainRepo
}