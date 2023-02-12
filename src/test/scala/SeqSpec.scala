import org.scalatest._
import org.scalatest.matchers._

class SeqSpec extends FreeSpec with GivenWhenThen with  Matchers {
	"A Seq" - {
		"New Seq" in {
			Given("new seq(1,2,3)")
			val seq = Seq(1,2,3)
			When("check size")
			val size = seq.size
			Then("size should be 3")
			size should be (3)
		}
		"Add new value" in {
			Given("seq(1,2,3)")
			val a = Seq(1,2,3)
			When("add new value")
			val b = a :+ 4
			val size = b.size
			println("## ->" + b)
			Then("size should be 4")
			size should be (4)
		}
	}
	
}