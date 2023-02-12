package org.zonghan.variance

/**
  * Created by wuzonghan on 17/2/15.
  * http://www.cnblogs.com/amunote/p/5693782.html
  * http://colobu.com/2015/05/19/Variance-lower-bounds-upper-bounds-in-Scala/
  */
object VarianceTes extends App {
  // 将子类对象赋值给超类称为协变；将超类对象赋值给子类称为逆变。默认情况下，scala对这两种“变”都不支持。
  var arr1:Array[Int] = new Array[Int](3)
  // var arr2:Array[Any] = arr1
  val a: Array2[Any] = new Array2[Int]

  val a1: Array3[Int] = new Array3[Any]

}

class Array2[+A]

class Array3[-A]
