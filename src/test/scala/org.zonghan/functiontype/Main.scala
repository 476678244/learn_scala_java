package org.zonghan.functiontype

/**
 * Created by wuzonghan on 17/3/22.
 */
object Main extends App {
  def myMethod(f: (Int, Double) => Boolean, p1: Int, p2: Double): Boolean = {
    return f(p1, p2)
  }

  def myMethod2[A, B](f: A => B): Unit = {}

  println(myMethod((p1, p2) => p1 > p2, 1, 2.2))

  //  def createCell(ha: HA, va: VA) =
  //    Cell("Align It", style = CellStyle(horizontalAlignment = ha, verticalAlignment = va))
  //  createCell(HA.Center, VA.Bottom)
  //  alignments.map((createCell _).tupled)
}
