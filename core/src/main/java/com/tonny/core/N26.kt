package com.tonny.core

import com.tonny.core.blockchain.BlockChainRepo

interface N26 {

  /**
   * Gateway to the Block chain repository
   *
   * @return [BlockChainRepo] interface to access public block chain apis.
   */
  fun getBlockChainRepo(): BlockChainRepo
}