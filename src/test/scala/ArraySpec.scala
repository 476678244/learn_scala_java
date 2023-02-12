import org.scalatest._
import org.scalatest.matchers._
class ArraySpec extends FreeSpec with GivenWhenThen with Matchers {
	"An Array" - {
		"New Array is empty" in {
			Given("New Array[String] as var x")
			var x = Array[String]()
			Then("x is empty")
			assert(x.isEmpty)
			And("x is size equals 0")
			x.size should be (0)
		}
	}
}