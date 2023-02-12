package org.zonghan.testtype

/**
  * Created by wuzonghan on 17/2/15.
  */
object TestType2 extends App {
  class Covariant[+A]

  val cv: Covariant[AnyRef] = new Covariant[String]

  class Contravariant[-A]

  val cv2: Contravariant[String] = new Contravariant[AnyRef]

  class Animal { val sound = "rustle" }

  class Bird extends Animal { override val sound = "call" }

  class Chicken extends Bird { override val sound = "cluck" }

  val getTweet: (Bird => String) = ((a: Animal) => a.sound )

  val hatch: (() => Bird) = (() => new Chicken )

  def biophony[T <: Animal](things: Seq[T]) = things map (_.sound)
  println(biophony(Seq(new Chicken, new Bird)))

  val flock = List(new Bird, new Bird)
  println(((new Animal) :: flock).getClass)
  println(((new Chicken) :: flock).getClass)

  def count[A](l: List[A]) = l.size

  def count2(l: List[_]) = l.size

  def count3(l: List[T forSome { type T }]) = l.size

  def drop1(l: List[_]) = l.tail

  def drop2(l: List[T forSome { type T }]) = l.tail

  def hashcodes(l: Seq[_ <: AnyRef]) = l map (x => x.hashCode)

  hashcodes(Seq("one", "two", "three"))
}
