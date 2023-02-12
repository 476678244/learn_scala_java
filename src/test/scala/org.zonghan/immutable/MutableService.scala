package org.zonghan.immutable

/**
  * Created by wuzonghan on 17/4/12.
  */
import collection.mutable.{HashMap=>MutableHashMap}

class MutableService[Key, Value] extends Service[Key, Value] {
  val currentIndex = new MutableHashMap[Key, Value]
  def lookUp(k: Key): Option[Value] = synchronized(currentIndex.get(k))
  def insert(k: Key, v: Value): Unit = synchronized { currentIndex.put(k,v) }
}