package org.zonghan.y2022

trait LRUCacheV2 {
  
  def get(key: Int): Int

  def put(key: Int, value: Int): Unit

}
