package org.zonghan.y2022

case class LRUCacheNode(k: Int, v: Int, n: LRUCacheNode, l: LRUCacheNode) {
  var key: Int = k
  var value: Int = v
  var next: LRUCacheNode = n
  var last: LRUCacheNode = l
}
