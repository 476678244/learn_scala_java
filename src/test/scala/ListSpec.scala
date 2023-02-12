import org.scalatest._

class ListSpec extends FlatSpec with GivenWhenThen {
	
	def fixture = 
		new {
			val l = List(1,2,3,4,5)
	}
		

	it should "found element 5 " in {
		val f = fixture
		Given("a list")

		When("contains value in list")
		var found = f.l.contains(5)

		Then("found in list")
		assert(found)
	}

	it should "found When add new element" in {
		
		Given( "list ")
		val l = List(1,2)
		When ("add 10 to list")
		var x = 10::l
		Then ("contains 10")
		assert(x.contains(10))
	}

	it should "be new list When merge 2 list" in {
		Given ("2 list")
		val l1 = List(1,2)
		val l2 = List(3,4)
		When("l3 is l1 merge with l2")
		val l3 = l1:::l2

		Then("l3 is contains value same on l1 and l2")
		assert(l3.contains(1))
		assert(l3.contains(2))
		assert(l3.contains(3))
		assert(l3.contains(4))

	}
}