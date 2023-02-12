import org.scalatest._
import org.scalatest.matchers._

class SetSpec extends FreeSpec with GivenWhenThen with Matchers{
		"A Set" -{
			"New set should be empty" in {
				Given("new set")
				var set = Set()
				Then("new set should be empty")
				assert(set.isEmpty)
				And("size is 0")
				set.size should be (0)
			}

			"Set add element" in {
				Given("a new set")
				var s = Set[Int]()
				When("add 1 element to set")
				s += 1
				Then("set not empty")
				assert(!s.isEmpty)
				And("set size should be 1")
				s.size should be (1)
			}

			"Set can be filter index" in {
				Given("New Set[Int] from 1 to 10 number")
				var x = Set[Int]()
				(1 to 10).map( x+=_)
				When("filter set and mod by 2")
				var b = x.filter(_ %2 ==0)
				Then("have a new set")
				assert(null != b)
				And("new set is size")
				b.size should be (5)
				And("new set contains 2,4,6,8,10")
				assert(b.contains(2))
				assert(b.contains(4))
				assert(b.contains(6))
				assert(b.contains(8))
				assert(b.contains(10))
			}

			"Set to List" in {
				Given("New Set[Int] as x")
				var x = Set[Int]()
				When("use to List to y")
				var y = x.toList
				Then("y is be the same instance as x")
				y should be theSameInstanceAs (x.toList)
			}

			
		}

}