package org.zonghan.oo.mixin

/**
  * Created by wuzonghan on 17/2/14.
  * We would like to combine the functionality of StringIterator and RichIterator into a single class.
  */
abstract class AbsIterator {
  type T
  def hasNext: Boolean
  def next: T
}

trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit) { while (hasNext) f(next) }
}

class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i = 0
  def hasNext = i < s.length()
  def next = { val ch = s charAt i; i += 1; ch }
}

object StringIteratorTest {
  def main(args: Array[String]) {
    class Iter extends StringIterator("Hello World ") with RichIterator
    val iter = new Iter

    def f(ch: Char) = {
      println(ch)
    }
    iter foreach f
    val iter2 = new Iter
    iter2 foreach println
  }
}