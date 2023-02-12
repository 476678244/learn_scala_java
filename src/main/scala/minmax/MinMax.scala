package minmax

class MinMax {
	def getResult(inputs: Array[Int]): Array[Int] = {
		val result = inputs.sorted
		return Array(result(0),result(result.length -1))
	}

	def testInt (x : Int) = println(x)
}