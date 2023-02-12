package org.zonghan.immutable

/**
  * Created by wuzonghan on 17/4/12.
  */
trait Service[Key,Value] {
  def lookUp(k: Key): Option[Value]
  def insert(k: Key, v: Value): Unit
}
