package org.zonghan.grammer

/**
  * Created by wuzonghan on 17/3/22.
  */
object Qsort extends App {

  def qsort[T <% Ordered[T]](list:List[T]):List[T] = list match {
    case  Nil => Nil
    case  x:: xs =>
      val (before, after) = xs partition( _ < x )
      qsort(before) ++ (x :: qsort(after))
  }

  Predef println qsort(List(1,3213,344,123123,4353,213123,435345,4,2,1))
}
