package minmax

import org.scalatest._

class MinMaxSpec extends FlatSpec with Matchers {

	it should "return 1 and 5 in array {1,2,3,4,5}" in {
		val minmax = new MinMax()
		val inputs = Array(1,2,3,4,5)
        minmax.getResult(inputs) should equal(Array(1,5))
	}

	it should "return 2 and 12 in array {2,4,1,1,12}" in {
		val minmax = new MinMax()
		val inputs = Array(2,4,5,6,12)
        minmax.getResult(inputs) should equal(Array(2,12))
	}

	it should "return 1 and 1 in array { 1 } " in {
		val minmax = new MinMax()
		val inputs = Array(1)
		minmax.getResult(inputs) should equal(Array(1,1))
	}
}