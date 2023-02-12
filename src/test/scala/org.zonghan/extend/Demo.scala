package org.zonghan.extend

/**
 * Created by wuzonghan on 17/2/15.
 */
class Point(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
    println("Point x location : " + x);
    println("Point y location : " + y);
  }
}

class Location(override val xc: Int, override val yc: Int,
  val zc: Int) extends Point(xc, yc) {
  var z: Int = zc

  // Note − Methods move() method in Point class and move() method in Location class
  // do not override the corresponding definitions of move since they are different definitions
  // (for example, the former take two arguments while the latter take three arguments).
  def move(dx: Int, dy: Int, dz: Int) {
    x = x + dx
    y = y + dy
    z = z + dz
    println("Point x location : " + x);
    println("Point y location : " + y);
    println("Point z location : " + z);
  }
}

object Demo {
  def main(args: Array[String]) {
    val loc = new Location(10, 20, 15);

    // Move to a new location
    loc.move(10, 10, 5);
  }
}