package com.tonny.core.blockchain

data class GraphData(
  var status: String = "",
  var name: String = "",
  val unit: String = "",
  val period: String = "",
  val description: String = "",
  val values: List<Coordinate> = ArrayList()
)

data class Coordinate(
  val x: Float,
  val y: Float
)