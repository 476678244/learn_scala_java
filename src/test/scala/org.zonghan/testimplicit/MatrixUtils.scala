package org.zonghan.testimplicit

/**
 * Created by wuzonghan on 2017/5/10.
 */
object MatrixUtils {

  def multiply(a: Matrix, b: Matrix)(implicit threading: ThreadStrategy = SameThreadStrategy): Matrix = {

    assert(a.colRank == b.rowRank)
    val buffer = new Array[Array[Double]](a.rowRank)
    for (i <- 0 until a.rowRank) {
      buffer(i) = new Array[Double](b.colRank)
    }

    def computeValue(row: Int, col: Int): Unit = {
      val pairwiseElements = a.row(row).zip(b.col(col))
      val products = for ((x, y) <- pairwiseElements) yield x * y
      val result = products.sum
      buffer(row)(col) = result

    }
    val computations = for {
      i <- 0 until a.rowRank
      j <- 0 until b.colRank
    } yield threading.execute { () => computeValue(i, j) }

    computations.foreach(_())
    new Matrix(buffer)

  }

}
