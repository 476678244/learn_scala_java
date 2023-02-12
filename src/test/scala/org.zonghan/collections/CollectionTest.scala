package org.zonghan.collections

/**
  * Created by wuzonghan on 17/2/15.
  */
object CollectionTest extends App {

  List(1, 2, 3)

  println(1 :: 2 :: 3 :: Nil)

  println(Set(1, 1, 2))

  println(Seq(1, 1, 2))

  println(Map('a' -> 1, 'b' -> 2))

  println((1 :: 2 :: 3 :: Nil).tail)

  // println((1 :: 2 :: 3 :: Nil).toMap)

  println(Map(1 -> 2).toArray)

  Map[String, Int](("1",1))

  Map.empty ++ List(("a", 1), ("b", 2), ("c", 3))

  1 to 5

  println((1 to 3).map { i => i })
  println(1 to 3)
}
