package org.zonghan.immutable
import collection.immutable.{HashMap=>ImmutableHashMap}
/**
  * Created by wuzonghan on 17/4/12.
  */
class ImmutableService[Key, Value] extends Service[Key, Value] {
  var currentIndex = new ImmutableHashMap[Key,Value]
  def lookUp(k: Key): Option[Value] = currentIndex.get(k)
  def insert(k: Key, v: Value): Unit = synchronized {
    currentIndex = currentIndex + ((k, v))
  }
}