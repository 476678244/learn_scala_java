import org.scalatest._

class BlockSpec extends FlatSpec with Matchers {
	val block = new Block(2,2,2)

	it should "return when getWidth" in {
            block.getWidth should be (2)
	}
        it should "return when getHeight" in {
            block.getHeight should be (2)
        }
        it should "return when getLength" in {
            block.getLength should be (2)
        }
        it should "return value when getVolumn" in {
            block.getVolumn should be (8)
        }
        it should "return value when getSurfaceArea" in {
            block.getSurfaceArea should be (24)
        }

}