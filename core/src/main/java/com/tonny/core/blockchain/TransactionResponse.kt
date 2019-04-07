package com.tonny.core.blockchain

data class TransactionResponse(
  val status: String,
  val name: String,
  val unit: String,
  val period: String,
  val description: String,
  val values: List<Coordinate>
)

data class Coordinate(
  val x: Double,
  val y: Double
)